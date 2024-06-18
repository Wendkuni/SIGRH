package com.sigrh.gestionressourceh.web.parametre;

import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.parametres.FonctionListeModel;
import com.sigrh.gestionressourceh.services.parametre.FonctionListeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class ListeFonctionController {
FonctionListeService service;


    @PostMapping(path = "/listeFonction")
    public ResponseEntity<ApiResponse<FonctionListeModel>> addListeFonction(@RequestBody FonctionListeModel model) {
        ApiResponse<FonctionListeModel> response;
        if (service.create(model)) {
            response = new ApiResponse
                    .Builder<FonctionListeModel>()
                    .message("Création d'une nouvelle ListeFonction")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<FonctionListeModel>()
                    .message("Echec de création de la ListeFonction")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/listeFonction/{id}")
    public ResponseEntity<ApiResponse<FonctionListeModel>> updateListeFonction (@RequestParam Integer id, FonctionListeModel model){
        ApiResponse<FonctionListeModel> response;
        if (service.update(id, model)) {
            response = new ApiResponse
                    .Builder<FonctionListeModel>()
                    .message("Mise à jour de la ListeFonction")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<FonctionListeModel>()
                    .message("Echec de mise à jour de la ListeFonction")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/listeFonction/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteListeFonction (@PathVariable Integer id){
        ApiResponse<Void> response;
        if (service.delete(id)) {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("suppression de la ListeFonction")
                    .status(HttpStatus.OK.value()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("Echec de suppression de la ListeFonction")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/listeFonctions")
    public ResponseEntity<ApiResponse<List<FonctionListeModel>>> getAllListeFonction () {
        ApiResponse<List<FonctionListeModel>> reponse = new ApiResponse.
                Builder<List<FonctionListeModel>>().status(HttpStatus.OK.value())
                .message("Liste des listeFonctions").result(service.findAll()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/listeFonctions/{id}")
    public ResponseEntity<ApiResponse<FonctionListeModel>> getListeFonctionById (@PathVariable Integer id){
        ApiResponse<FonctionListeModel> reponse = new ApiResponse.
                Builder<FonctionListeModel>().status(HttpStatus.OK.value())
                .message("Liste des ListeFonctions par identifiant").result(service.find(id)).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
