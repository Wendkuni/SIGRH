package com.sigrh.gestionressourceh.web.parametre;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.parametres.AssurancesModel;
import com.sigrh.gestionressourceh.services.parametre.AssuranceService;
import com.sigrh.gestionressourceh.web.RestControllerTemplate;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class AssuranceController implements RestControllerTemplate<AssurancesModel> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    AssuranceService service;

    @PostMapping(path = "/assurance")
    @Override
    public ResponseEntity<ApiResponse<Boolean>> create(@RequestBody AssurancesModel obj) {

        boolean isOk = service.create(obj);
        ApiResponse<Boolean> response=new ApiResponse.Builder<Boolean>()
                .status(HttpStatus.OK.value())
                .message(isOk?"Création d'assurance reussie":"échec de la création")
                .result(isOk)
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path = "/assurance/delete/{id}")
    @Override
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable int id) {

        boolean isOk = service.delete(id);
        ApiResponse<Void> response=new ApiResponse.Builder<Void>()
                .status(HttpStatus.OK.value())
                .message(isOk?"suppression de l'assurance reussie":"échec de la suppression")
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path = "/assurance/delete")
    @Override
    public ResponseEntity<ApiResponse<Void>> delete(@RequestPart(value = "assurance") String assurance) {
        boolean isOk;
        ApiResponse<Void> response;
        try {
            objectMapper.findAndRegisterModules();
            AssurancesModel model = objectMapper.readValue(assurance, AssurancesModel.class);
            isOk = service.delete(model);
            response = new ApiResponse.Builder<Void>()
                    .status(HttpStatus.OK.value())
                    .message(isOk ? "suppression de l'assurance reussie":"échec de la suppression")
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(response, isOk ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping(path = "/assurance/{id}")
    @Override
    public ResponseEntity<ApiResponse<Boolean>> update(AssurancesModel obj) {
        boolean isOk = service.update(obj);
        ApiResponse<Boolean> response=new ApiResponse.Builder<Boolean>()
                .status(HttpStatus.OK.value())
                .message(isOk?"mise à jour de l'assurance reussie":"échec de la mise à jour ")
                .result(isOk)
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/assurancesBy/{id}")
    @Override
    public ResponseEntity<ApiResponse<AssurancesModel>> find(@PathVariable int id) {
        AssurancesModel model = service.find(id);
        boolean isOk = model!=null;
        ApiResponse<AssurancesModel> response=new ApiResponse.Builder<AssurancesModel>()
                .status(HttpStatus.OK.value())
                .message(isOk?"Assurance trouvée":"Aucune assurance trouvée")
                .result(model)
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/assurances")
    @Override
    public ResponseEntity<ApiResponse<List<AssurancesModel>>> findAll() {

        List<AssurancesModel> list = service.findAll();
        boolean isOk=list!=null;
        ApiResponse<List<AssurancesModel>> response=new ApiResponse.Builder<List<AssurancesModel>>()
                .status(HttpStatus.OK.value())
                .message(isOk?"Liste des assurances":"Aucun élément trouvé")
                .result(list)
                .build();

        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/assurancesByAgent/{id}")
    public ResponseEntity<ApiResponse<List<AssurancesModel>>> findByAgent(@PathVariable int id) {

        List<AssurancesModel> list = service.findByAgent(id);
        boolean isOk=list!=null;
        ApiResponse<List<AssurancesModel>> response=new ApiResponse.Builder<List<AssurancesModel>>()
                .status(HttpStatus.OK.value())
                .message(isOk?"Liste des assurances par agent":"Aucun élément trouvé")
                .result(list)
                .build();

        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
