package com.sigrh.gestionressourceh.web.personnel;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.services.personnel.AffectationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/affectation")
@AllArgsConstructor
public class AffectationController {
    AffectationService service;

    @PostMapping(path = "/create")
    public boolean addAffectation(@RequestBody PersonnelAffectationModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/update/{id}")
    public boolean updateAffectation(@RequestParam Integer id, PersonnelAffectationModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteAffectation(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/All")
    public List<PersonnelAffectationModel> getAllAffectation() {
        return service.findAll();
    }

    @GetMapping(path = "/ByAgent")
    public List<PersonnelAffectationModel> getAffectationByAgent(@PathVariable int IDagent) {
        return service.findByAgent(IDagent);
    }

    @GetMapping(path = "/ById/{id}")
    public PersonnelAffectationModel getAffectationById(@PathVariable Integer id) {
        return service.find(id);
    }
}
