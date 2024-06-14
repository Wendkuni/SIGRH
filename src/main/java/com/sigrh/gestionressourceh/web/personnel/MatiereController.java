package com.sigrh.gestionressourceh.web.personnel;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelMatieresModel;
import com.sigrh.gestionressourceh.services.personnel.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class MatiereController {
     MatiereService service;


    @PostMapping(path = "/matiere")
    public boolean addMatiere(@RequestBody PersonnelMatieresModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/matiere/{id}")
    public boolean updateMatiere(@RequestParam Integer id, PersonnelMatieresModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/matiere/delete/{id}")
    public boolean deleteMatiere(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/matieres")
    public List<PersonnelMatieresModel> getAllMatiere() {
        return service.findAll();
    }

    @GetMapping(path = "/matiereBy/{id}")
    public PersonnelMatieresModel getMatiereById(@PathVariable Integer id) {
        return service.find(id);
    }
}


