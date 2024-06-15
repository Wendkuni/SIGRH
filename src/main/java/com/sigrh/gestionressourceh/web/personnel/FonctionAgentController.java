package com.sigrh.gestionressourceh.web.personnel;

import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelFonctionModel;
import com.sigrh.gestionressourceh.services.personnel.FonctionAgentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class FonctionAgentController {

FonctionAgentService service;

    @PostMapping(path = "/fonctionAgent")
    public ResponseEntity<ApiResponse<PersonnelFonctionModel>> addFonctionAgent(@RequestBody PersonnelFonctionModel model) {
        ApiResponse<PersonnelFonctionModel> response;
        if (service.create(model)) {
            response = new ApiResponse
                    .Builder<PersonnelFonctionModel>()
                    .message("Création d'une fonctionAgent absence")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<PersonnelFonctionModel>()
                    .message("Echec de création de la fonctionAgent")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/fonctionAgent/{id}")
    public ResponseEntity<ApiResponse<PersonnelFonctionModel>> updateFonctionAgent (@RequestParam Integer id, PersonnelFonctionModel model){
        ApiResponse<PersonnelFonctionModel> response;
        if (service.update(id, model)) {
            response = new ApiResponse
                    .Builder<PersonnelFonctionModel>()
                    .message("Mise à jour de la fonctionAgent")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<PersonnelFonctionModel>()
                    .message("Echec de mise à jour de la fonctionAgent")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/fonctionAgent/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteFonctionAgent (@PathVariable Integer id){
        ApiResponse<Void> response;
        if (service.delete(id)) {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("suppression de la fonctionAgent")
                    .status(HttpStatus.OK.value()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("Echec de suppression de la fonctionAgent")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/fonctionAgents")
    public ResponseEntity<ApiResponse<List<PersonnelFonctionModel>>> getAllFonctionAgent () {
        ApiResponse<List<PersonnelFonctionModel>> reponse = new ApiResponse.
                Builder<List<PersonnelFonctionModel>>().status(HttpStatus.OK.value())
                .message("Liste des absences").result(service.findAll()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/fonctionAgents/{id}")
    public ResponseEntity<ApiResponse<PersonnelFonctionModel>> getFonctionAgentById (@PathVariable Integer id){
        ApiResponse<PersonnelFonctionModel> reponse = new ApiResponse.
                Builder<PersonnelFonctionModel>().status(HttpStatus.OK.value())
                .message("Liste des fonctionAgents par identifiant").result(service.find(id)).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
