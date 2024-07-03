package net.gestion.pgcongeabsence.web.personnel;

import lombok.AllArgsConstructor;
import net.gestion.pgcongeabsence.common.ApiResponse;
import net.gestion.pgcongeabsence.domains.personnel.PersonnelAbsenceModel;
import net.gestion.pgcongeabsence.services.personnel.AbsenceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/absence")
@AllArgsConstructor
public class AbsenceAndCongeController {
    AbsenceService service;

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse<PersonnelAbsenceModel>> addAbsence(@RequestBody PersonnelAbsenceModel model) {
        ApiResponse<PersonnelAbsenceModel> response;
        if (service.create(model)) {
            response = new ApiResponse
                    .Builder<PersonnelAbsenceModel>()
                    .message("Création d'une nouvelle absence")
                    .status(HttpStatus.OK.value())
                    .result(model).build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response = new ApiResponse
                    .Builder<PersonnelAbsenceModel>()
                    .message("Echec de création de l'absence")
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
        @PutMapping(path = "/update/{id}")
        public ResponseEntity<ApiResponse<PersonnelAbsenceModel>> updateAbsence (@PathVariable Integer id, @RequestBody PersonnelAbsenceModel model){
            ApiResponse<PersonnelAbsenceModel> response;
            if (service.update(id, model)) {
                response = new ApiResponse
                        .Builder<PersonnelAbsenceModel>()
                        .message("Mise à jour de l'absence")
                        .status(HttpStatus.OK.value())
                        .result(model).build();
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response = new ApiResponse
                        .Builder<PersonnelAbsenceModel>()
                        .message("Echec de mise à jour de l'absence")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build();
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @DeleteMapping(path = "/delete/{id}")
        public ResponseEntity<ApiResponse<Void>> deleteAbsence (@PathVariable Integer id){
            ApiResponse<Void> response;
            if (service.delete(id)) {
                response = new ApiResponse
                        .Builder<Void>()
                        .message("suppression de l'absence")
                        .status(HttpStatus.OK.value()).build();
                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                response = new ApiResponse
                        .Builder<Void>()
                        .message("Echec de suppression de l'absence")
                        .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .build();
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        @GetMapping(path = "/All")
        public ResponseEntity<ApiResponse<List<PersonnelAbsenceModel>>> getAllAbsence () {
            ApiResponse<List<PersonnelAbsenceModel>> reponse = new ApiResponse.
                    Builder<List<PersonnelAbsenceModel>>().status(HttpStatus.OK.value())
                    .message("Liste des absences").result(service.findAll()).build();
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        }

        @GetMapping(path = "/ById/{id}")
        public ResponseEntity<ApiResponse<PersonnelAbsenceModel>> getAbsenceById (@PathVariable Integer id){
            ApiResponse<PersonnelAbsenceModel> reponse = new ApiResponse.
                    Builder<PersonnelAbsenceModel>().status(HttpStatus.OK.value())
                    .message("Liste des absences par identifiant").result(service.find(id)).build();
            return new ResponseEntity<>(reponse, HttpStatus.OK);
        }
    }