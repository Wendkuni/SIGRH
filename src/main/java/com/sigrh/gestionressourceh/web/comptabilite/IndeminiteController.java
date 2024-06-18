package com.sigrh.gestionressourceh.web.comptabilite;

import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.comptablite.IndeminiteModel;
import com.sigrh.gestionressourceh.services.comptabilite.IndeminiteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class IndeminiteController {
    IndeminiteService service;

    @PostMapping(path = "/indeminite")
    public ResponseEntity<ApiResponse<IndeminiteModel>> addIndeminite(@RequestBody IndeminiteModel model) {
        ApiResponse<IndeminiteModel> response;
        if (service.create(model)) {
            response = new ApiResponse
                    .Builder<IndeminiteModel>()
                    .message("Création d'une nouvelle indeminite")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<IndeminiteModel>()
                    .message("Echec de création de l'indeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/indeminite/{id}")
    public ResponseEntity<ApiResponse<IndeminiteModel>> updateIndeminite (@RequestParam Integer id, IndeminiteModel model){
        ApiResponse<IndeminiteModel> response;
        if (service.update(id, model)) {
            response = new ApiResponse
                    .Builder<IndeminiteModel>()
                    .message("Mise à jour de l'indeminite")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<IndeminiteModel>()
                    .message("Echec de mise à jour de l'indeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/indeminite/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteIndeminite (@PathVariable Integer id){
        ApiResponse<Void> response;
        if (service.delete(id)) {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("suppression de l'indeminite")
                    .status(HttpStatus.OK.value()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("Echec de suppression de l'indeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/indeminites")
    public ResponseEntity<ApiResponse<List<IndeminiteModel>>> getAllIndeminite () {
        ApiResponse<List<IndeminiteModel>> reponse = new ApiResponse.
                Builder<List<IndeminiteModel>>().status(HttpStatus.OK.value())
                .message("Liste des indeminites").result(service.findAll()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/indeminites/{id}")
    public ResponseEntity<ApiResponse<IndeminiteModel>> getIndeminiteById (@PathVariable Integer id){
        ApiResponse<IndeminiteModel> reponse = new ApiResponse.
                Builder<IndeminiteModel>().status(HttpStatus.OK.value())
                .message("Liste des indeminites par identifiant").result(service.find(id)).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
