package com.sigrh.gestionressourceh.web.personnel;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelAbsenceModel;
import com.sigrh.gestionressourceh.services.personnel.AbsenceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class AbsenceController {

    AbsenceService service;

    @PostMapping(path = "/absence")
    public boolean addAbsence(@RequestBody PersonnelAbsenceModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/absence/{id}")
    public boolean updateAbsence(@RequestParam Integer id, PersonnelAbsenceModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/absence/delete/{id}")
    public boolean deleteAbsence(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/absences")
    public List<PersonnelAbsenceModel> getAllAbsence() {
        return service.findAll();
    }

    @GetMapping(path = "/absences/{id}")
    public PersonnelAbsenceModel getAbsenceById(@PathVariable Integer id) {
        return service.find(id);
    }
}
