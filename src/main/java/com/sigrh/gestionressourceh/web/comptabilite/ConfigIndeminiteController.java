package com.sigrh.gestionressourceh.web.comptabilite;

import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.comptablite.ConfigIdemitModel;
import com.sigrh.gestionressourceh.services.comptabilite.ConfigIndeminiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class ConfigIndeminiteController {
    ConfigIndeminiteService service;

    @PostMapping(path = "/configIndeminite")
    public ResponseEntity<ApiResponse<ConfigIdemitModel>> addConfigIndeminite(@RequestBody ConfigIdemitModel model) {
        ApiResponse<ConfigIdemitModel> response;
        if (service.create(model)) {
            response = new ApiResponse
                    .Builder<ConfigIdemitModel>()
                    .message("Création d'une nouvelle configuration d'Indeminite")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<ConfigIdemitModel>()
                    .message("Echec de création de la configuration d'Indeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/configIndeminite/{id}")
    public ResponseEntity<ApiResponse<ConfigIdemitModel>> updateConfigIndeminite (@RequestParam Integer id, ConfigIdemitModel model){
        ApiResponse<ConfigIdemitModel> response;
        if (service.update(id, model)) {
            response = new ApiResponse
                    .Builder<ConfigIdemitModel>()
                    .message("Mise à jour de la configuration d'Indeminite")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<ConfigIdemitModel>()
                    .message("Echec de mise à jour de la configuration d'Indeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/configIndeminite/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteConfigIndeminite (@PathVariable Integer id){
        ApiResponse<Void> response;
        if (service.delete(id)) {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("suppression de la configuration d'Indeminite")
                    .status(HttpStatus.OK.value()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("Echec de suppression de la configuration d'Indeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/configIdemites")
    public ResponseEntity<ApiResponse<List<ConfigIdemitModel>>> getAllConfigIdemite () {
        ApiResponse<List<ConfigIdemitModel>> reponse = new ApiResponse.
                Builder<List<ConfigIdemitModel>>().status(HttpStatus.OK.value())
                .message("Liste des ConfigIdemites").result(service.findAll()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/configIdemites/{id}")
    public ResponseEntity<ApiResponse<ConfigIdemitModel>> getConfigIdemiteById (@PathVariable Integer id){
        ApiResponse<ConfigIdemitModel> reponse = new ApiResponse.
                Builder<ConfigIdemitModel>().status(HttpStatus.OK.value())
                .message("Liste des ConfigIdemites par identifiant").result(service.find(id)).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
