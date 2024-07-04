package com.sigrh.gestionressourceh.web.parametre;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.parametres.AllocationFamilleModel;
import com.sigrh.gestionressourceh.domains.parametres.AssurancesModel;
import com.sigrh.gestionressourceh.services.parametre.AllocationFamilleService;
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
public class AllocationFamilleController implements RestControllerTemplate<AllocationFamilleModel> {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private AllocationFamilleService service;
    /**
     * @param obj 
     * @return
     */

    @PostMapping(path = "/allocationFamille")
    @Override
    public ResponseEntity<ApiResponse<Boolean>> create(@RequestBody AllocationFamilleModel obj) {
        boolean isOk = service.create(obj);
        ApiResponse<Boolean> response=new ApiResponse.Builder<Boolean>()
                .status(HttpStatus.OK.value())
                .message(isOk?"Création d'allocationFamille reussie":"échec de la création")
                .result(isOk)
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param id 
     * @return
     */
    @DeleteMapping(path = "/allocationFamille/delete/{id}")
    @Override
    public ResponseEntity<ApiResponse<Void>> delete(int id) {
        boolean isOk = service.delete(id);
        ApiResponse<Void> response=new ApiResponse.Builder<Void>()
                .status(HttpStatus.OK.value())
                .message(isOk?"suppression de l'allocationFamille reussie":"échec de la suppression")
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param allocation
     * @return
     */
    @DeleteMapping(path = "/allocationFamille/delete")
    @Override
    public ResponseEntity<ApiResponse<Void>> delete(@RequestPart(value = "allocation") String allocation) {
        boolean isOk;
        ApiResponse<Void> response;
        try {
            objectMapper.findAndRegisterModules();
            AllocationFamilleModel model = objectMapper.readValue(allocation, AllocationFamilleModel.class);
            isOk = service.delete(model);
            response = new ApiResponse.Builder<Void>()
                    .status(HttpStatus.OK.value())
                    .message(isOk ? "suppression de l'allocationFamille reussie":"échec de la suppression")
                    .build();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new ResponseEntity<>(response, isOk ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param obj 
     * @return
     */
    @PutMapping(path = "/allocationFamille/{id}")
    @Override
    public ResponseEntity<ApiResponse<Boolean>> update(@PathVariable int id,AllocationFamilleModel obj) {
        boolean isOk = service.update(id,obj);
        ApiResponse<Boolean> response=new ApiResponse.Builder<Boolean>()
                .status(HttpStatus.OK.value())
                .message(isOk?"mise à jour de l'allocationFamille reussie":"échec de la mise à jour ")
                .result(isOk)
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @param id 
     * @return
     */
    @GetMapping(path = "/allocationFamillesBy/{id}")
    @Override
    public ResponseEntity<ApiResponse<AllocationFamilleModel>> find(@PathVariable int id) {
        AllocationFamilleModel model = service.find(id);
        boolean isOk = model!=null;
        ApiResponse<AllocationFamilleModel> response=new ApiResponse.Builder<AllocationFamilleModel>()
                .status(HttpStatus.OK.value())
                .message(isOk?"allocationFamille trouvée":"Aucune allocationFamille trouvée")
                .result(model)
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * @return 
     */
    @GetMapping(path = "/allocationFamilles")
    @Override
    public ResponseEntity<ApiResponse<List<AllocationFamilleModel>>> findAll() {
        List<AllocationFamilleModel> list = service.findAll();
        boolean isOk=list!=null;
        ApiResponse<List<AllocationFamilleModel>> response=new ApiResponse.Builder<List<AllocationFamilleModel>>()
                .status(HttpStatus.OK.value())
                .message(isOk?"Liste des allocationFamille":"Aucun élément trouvé")
                .result(list)
                .build();
        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/allocationFamillesByAgent/{id}")
    public ResponseEntity<ApiResponse<List<AllocationFamilleModel>>> findByAgent(@PathVariable int id) {

        List<AllocationFamilleModel> list = service.findByAgent(id);
        boolean isOk=list!=null;
        ApiResponse<List<AllocationFamilleModel>> response=new ApiResponse.Builder<List<AllocationFamilleModel>>()
                .status(HttpStatus.OK.value())
                .message(isOk?"Liste des allocationFamilles par agent":"Aucun élément trouvé")
                .result(list)
                .build();

        return new ResponseEntity<>(response,isOk?HttpStatus.OK:HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
