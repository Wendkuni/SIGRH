package com.sigrh.gestionressourceh.web;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import com.sigrh.gestionressourceh.services.PersonnelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class PersonnelController  {
    @Autowired
    private PersonnelService service;

    @PostMapping(path = "/personnel")
    public boolean addPersonnel(@RequestBody PersonnelModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/personnel/{id}")
    public boolean updatePersonnel(@RequestParam Integer id, PersonnelModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/personnel/delete/{id}")
    public boolean deletePersonnel(@PathVariable Integer id) {
        return service.delete(id);
    }
}
