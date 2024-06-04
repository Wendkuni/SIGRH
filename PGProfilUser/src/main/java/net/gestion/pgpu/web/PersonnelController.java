package net.gestion.pgpu.web;


import lombok.AllArgsConstructor;
import net.gestion.pgpu.domaine.personnel.PersonnelModel;
import net.gestion.pgpu.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/personnels")
    public List<PersonnelModel> getAllPersonnel() {
        return service.findAll();
    }

    @GetMapping(path = "/personnelsBy/{id}")
    public PersonnelModel getPersonnelById(@PathVariable Integer id) {
        return service.find(id);
    }
}
