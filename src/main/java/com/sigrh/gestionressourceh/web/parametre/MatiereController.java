package com.sigrh.gestionressourceh.web.parametre;

import com.sigrh.gestionressourceh.domains.parametres.PersonnelMatieresModel;
import com.sigrh.gestionressourceh.services.parametre.MatiereService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/matiere")
@AllArgsConstructor
public class MatiereController {
     MatiereService service;


    @PostMapping(path = "/create")
    public boolean addMatiere(@RequestBody PersonnelMatieresModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/Update/{id}")
    public boolean updateMatiere(@RequestParam Integer id, PersonnelMatieresModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteMatiere(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/All")
    public List<PersonnelMatieresModel> getAllMatiere() {
        return service.findAll();
    }

    @GetMapping(path = "/ById/{id}")
    public PersonnelMatieresModel getMatiereById(@PathVariable Integer id) {
        return service.find(id);
    }
}


