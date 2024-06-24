package com.sigrh.gestionressourceh.web.personnel;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.services.personnel.AffectationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class AffectationController {
    AffectationService service;

    @PostMapping(path = "/affectation")
    public boolean addAffectation(@RequestBody PersonnelAffectationModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/affectation/{id}")
    public boolean updateAffectation(@RequestParam Integer id, PersonnelAffectationModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/affectation/delete/{id}")
    public boolean deleteAffectation(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/affectations")
    public List<PersonnelAffectationModel> getAllAffectation() {
        return service.findAll();
    }

    @GetMapping(path = "/affectationsBy/{id}")
    public PersonnelAffectationModel getAffectationById(@PathVariable Integer id) {
        return service.find(id);
    }

    @GetMapping(path = "/affectationsByAgent/{IDagent}")
    public PersonnelAffectationModel getAffectationByAgent(@PathVariable Integer IDagent) {
        return service.find(IDagent);
    }

}