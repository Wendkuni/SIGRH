package net.gestion.pgremuneration.web.parametre;


import lombok.AllArgsConstructor;
import net.gestion.pgremuneration.common.ApiResponse;
import net.gestion.pgremuneration.domains.parametres.IndeminitesListeModel;
import net.gestion.pgremuneration.services.parametre.IndeminiteListeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class ListeIndeminiteController {

    IndeminiteListeService service;

    @PostMapping(path = "/listeIndeminite")
    public ResponseEntity<ApiResponse<IndeminitesListeModel>> addListeIndeminite(@RequestBody IndeminitesListeModel model) {
        ApiResponse<IndeminitesListeModel> response;
        if (service.create(model)) {
            response = new ApiResponse
                    .Builder<IndeminitesListeModel>()
                    .message("Création d'une nouvelle listeIndeminite")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<IndeminitesListeModel>()
                    .message("Echec de création de la listeIndeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(path = "/listeIndeminite/{id}")
    public ResponseEntity<ApiResponse<IndeminitesListeModel>> updateListeIndeminite (@RequestParam Integer id, IndeminitesListeModel model){
        ApiResponse<IndeminitesListeModel> response;
        if (service.update(id, model)) {
            response = new ApiResponse
                    .Builder<IndeminitesListeModel>()
                    .message("Mise à jour de la listeIndeminite")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<IndeminitesListeModel>()
                    .message("Echec de mise à jour de la listeIndeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/listeIndeminite/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteListeIndeminite (@PathVariable Integer id){
        ApiResponse<Void> response;
        if (service.delete(id)) {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("suppression de la listeIndeminite")
                    .status(HttpStatus.OK.value()).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<Void>()
                    .message("Echec de suppression de la listeIndeminite")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/listeIndeminites")
    public ResponseEntity<ApiResponse<List<IndeminitesListeModel>>> getAllListeIndeminite () {
        ApiResponse<List<IndeminitesListeModel>> reponse = new ApiResponse.
                Builder<List<IndeminitesListeModel>>().status(HttpStatus.OK.value())
                .message("Liste des listeIndeminites").result(service.findAll()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/listeIndeminites/{id}")
    public ResponseEntity<ApiResponse<IndeminitesListeModel>> getListeIndeminiteById (@PathVariable Integer id){
        ApiResponse<IndeminitesListeModel> reponse = new ApiResponse.
                Builder<IndeminitesListeModel>().status(HttpStatus.OK.value())
                .message("Liste des listeIndeminites par identifiant").result(service.find(id)).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }
}
