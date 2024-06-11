package com.sigrh.gestionressourceh.web.personnel;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import com.sigrh.gestionressourceh.services.personnel.DossierService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class DossierController {
    DossierService service;


    @PostMapping(path = "/dossier")
    public boolean addDossier(@RequestBody PersonnelDossierScanModel model) {
        return service.create(model);
    }

    @PutMapping(path = "/dossier/{id}")
    public boolean updateDossier(@RequestParam Integer id, PersonnelDossierScanModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/dossier/delete/{id}")
    public boolean deleteDossier(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/dossiers")
    public List<PersonnelDossierScanModel> getAllDossier() {
        return service.findAll();
    }

    @GetMapping(path = "/dossiersBy/{id}")
    public PersonnelDossierScanModel getDossierById(@PathVariable Integer id) {
        return service.find(id);
    }
}
