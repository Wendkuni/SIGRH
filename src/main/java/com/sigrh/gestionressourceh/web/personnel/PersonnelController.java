package com.sigrh.gestionressourceh.web.personnel;

import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import com.sigrh.gestionressourceh.services.personnel.PersonnelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/personnel")
@AllArgsConstructor
public class PersonnelController  {
    @Autowired
    private PersonnelService service;

    @PostMapping(path = "/create")
    public boolean addPersonnel(@RequestBody PersonnelModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/updade/{id}")
    public boolean updatePersonnel(@PathVariable Integer id, @RequestBody PersonnelModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deletePersonnel(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/All")
    public List<PersonnelModel> getAllPersonnel() {
        return service.findAll();
    }

    @GetMapping(path = "/ById/{id}")
    public PersonnelModel getPersonnelById(@PathVariable Integer id) {
        return service.find(id);
    }

    @GetMapping(path = "/ByAffectation/{id}")
    public List<PersonnelModel> getAllPersonnelByAffectation(@PathVariable Integer id) {
        return service.findByAffectation(id);
    }

    @GetMapping(path = "/ByLocalite/{id}")
    public List<PersonnelModel> getAllPersonnelByLocalite(@PathVariable String id) {
        return service.findByLocalite(id);
    }

    @GetMapping(path = "/TypeEducations")
    public ResponseEntity<ApiResponse<List<String>>> getAllTypeEducation(){
        List<String> types = Arrays.stream(TypeEducation.values()).map(e->e.toString().toUpperCase()).toList();
        ApiResponse<List<String>> response=new ApiResponse.Builder<List<String>>().
        status(HttpStatus.OK.value())
                .message("Liste des types éducation").result(types).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
