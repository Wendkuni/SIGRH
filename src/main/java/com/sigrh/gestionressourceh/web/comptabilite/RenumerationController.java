package com.sigrh.gestionressourceh.web.comptabilite;

import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.comptablite.RenumerationAgentModel;
import com.sigrh.gestionressourceh.services.comptabilite.RenumerationAgentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class RenumerationController {
RenumerationAgentService service;
    @PostMapping(path = "/renumeration")
    public ResponseEntity<ApiResponse<RenumerationAgentModel>> addRenumeration(@RequestBody RenumerationAgentModel model) {
        ApiResponse<RenumerationAgentModel> response;
        if (service.create(model)) {
            response = new ApiResponse
                    .Builder<RenumerationAgentModel>()
                    .message("Création d'une nouvelle renumeration")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<RenumerationAgentModel>()
                    .message("Echec de création de la renumeration")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/renumeration/{id}")
    public ResponseEntity<ApiResponse<RenumerationAgentModel>> updateRenumeration (@RequestParam Integer id, RenumerationAgentModel model){
        ApiResponse<RenumerationAgentModel> response;
        if (service.update(id, model)) {
            response = new ApiResponse
                    .Builder<RenumerationAgentModel>()
                    .message("Mise à jour de la renumeration")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<RenumerationAgentModel>()
                    .message("Echec de mise à jour de le renumeration")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/renumeration/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteRenumeration (@PathVariable Integer id){
        ApiResponse<Void> response;
        if (service.delete(id)) {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("suppression de la renumeration")
                    .status(HttpStatus.OK.value()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("Echec de suppression de la renumeration")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/renumerations")
    public ResponseEntity<ApiResponse<List<RenumerationAgentModel>>> getAllRenumeration () {
        ApiResponse<List<RenumerationAgentModel>> reponse = new ApiResponse.
                Builder<List<RenumerationAgentModel>>().status(HttpStatus.OK.value())
                .message("Liste des Renumerations").result(service.findAll()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/renumerations/{id}")
    public ResponseEntity<ApiResponse<RenumerationAgentModel>> getRenumerationById (@PathVariable Integer id){
        ApiResponse<RenumerationAgentModel> reponse = new ApiResponse.
                Builder<RenumerationAgentModel>().status(HttpStatus.OK.value())
                .message("Liste des renumerations par identifiant").result(service.find(id)).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
