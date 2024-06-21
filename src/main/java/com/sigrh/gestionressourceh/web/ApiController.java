package com.sigrh.gestionressourceh.web;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import com.sigrh.gestionressourceh.services.personnel.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api")
public class ApiController {

    @Autowired
    private PersonnelService personnelService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/ById/{id}")
    public ResponseEntity<PersonnelModel> getById(@PathVariable int id) {
        PersonnelModel personnel = personnelService.find(id);
        if (personnel != null) {
            return ResponseEntity.ok(personnel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
