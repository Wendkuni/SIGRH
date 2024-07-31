package net.gestion.pgremuneration.web.personnel;


import lombok.AllArgsConstructor;
import net.gestion.pgremuneration.common.ApiResponse;
import net.gestion.pgremuneration.domains.personnel.PersonnelFonctionModel;
import net.gestion.pgremuneration.services.personnel.FonctionAgentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/fonctionAgent")
@AllArgsConstructor
public class FonctionAgentController {

FonctionAgentService service;

    @PostMapping(path = "/create")
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
    @PutMapping(path = "/Update/{id}")
    public ResponseEntity<ApiResponse<PersonnelFonctionModel>> updateFonctionAgent (@PathVariable Integer id, @RequestBody PersonnelFonctionModel model){
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

    @DeleteMapping(path = "/delete/{id}")
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

    @GetMapping(path = "/All")
    public ResponseEntity<ApiResponse<List<PersonnelFonctionModel>>> getAllFonctionAgent () {
        ApiResponse<List<PersonnelFonctionModel>> reponse = new ApiResponse.
                Builder<List<PersonnelFonctionModel>>().status(HttpStatus.OK.value())
                .message("Liste des absences").result(service.findAll()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/ById/{id}")
    public ResponseEntity<ApiResponse<PersonnelFonctionModel>> getFonctionAgentById (@PathVariable Integer id){
        ApiResponse<PersonnelFonctionModel> reponse = new ApiResponse.
                Builder<PersonnelFonctionModel>().status(HttpStatus.OK.value())
                .message("Liste des fonctionAgents par identifiant").result(service.find(id)).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/ByAgent/{IDagent}")
    public List<PersonnelFonctionModel> getFonctionByAgent(@PathVariable int IDagent) {
        return service.findByAgent(IDagent);
    }


}