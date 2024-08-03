package mr.sigrh.sigusers.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import mr.sigrh.sigusers.dto.Utilisateur;
import mr.sigrh.sigusers.dto.UtilisateurComplet;
import mr.sigrh.sigusers.service.KeycloakClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/keycloak")
public class KeycloakClientController {

    private static final Logger logger = Logger.getLogger(KeycloakClientController.class.getName());

    @Autowired
    private KeycloakClientService keycloakClientService;

    @PostMapping("/createUser")
    @Operation(summary = "Create a new user", description = "Creates a new user in Keycloak.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully created",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Utilisateur.class))),
            @ApiResponse(responseCode = "500", description = "Failed to create user")
    })
    public ResponseEntity<Utilisateur> createUser(@RequestBody UtilisateurComplet user) {
        try {
            Utilisateur createdUser = keycloakClientService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to create user", e);
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/users")
    @Operation(summary = "Finds users", description = "Finds all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns users list",
                    content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Utilisateur.class)))),
            @ApiResponse(responseCode = "403", description = "Unauthorized to perform this action.")
    })
    public ResponseEntity<List<Utilisateur>> getUsers() {
        try {
            List<Utilisateur> users = keycloakClientService.getUsers();
            return ResponseEntity.ok(users);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to get users", e);
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    @Operation(summary = "Delete a user", description = "Deletes a user from Keycloak.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User successfully deleted"),
            @ApiResponse(responseCode = "500", description = "Failed to delete user")
    })
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        try {
            keycloakClientService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to delete user", e);
            return ResponseEntity.status(500).build();
        }
    }
}
