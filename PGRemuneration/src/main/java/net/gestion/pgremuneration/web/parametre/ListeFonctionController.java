package net.gestion.pgremuneration.web.parametre;


import lombok.AllArgsConstructor;
import net.gestion.pgremuneration.common.ApiResponse;
import net.gestion.pgremuneration.domains.parametres.FonctionListeModel;
import net.gestion.pgremuneration.services.parametre.FonctionListeService;
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

    @GetMapping(path = "/ListeEchelle")
    public ResponseEntity<ApiResponse<List<String>>> getAllListeEchelle () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des echelles").result(service.ListEchelle()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/ListeGrade")
    public ResponseEntity<ApiResponse<List<String>>> getAllListeGrade () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des grades").result(service.ListGrades()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
    @GetMapping(path = "/ListeEchelon")
    public ResponseEntity<ApiResponse<List<String>>> getAllListeEchelon () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des echelons").result(service.ListEchelon()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/AllLibFonction")
    public ResponseEntity<ApiResponse<List<String>>> getAllLibFonction () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des echelons").result(service.LibFonction()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
