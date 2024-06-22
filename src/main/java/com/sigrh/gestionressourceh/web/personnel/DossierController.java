package com.sigrh.gestionressourceh.web.personnel;


import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import com.sigrh.gestionressourceh.services.personnel.DossierService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/dossier")
@AllArgsConstructor
public class DossierController {
    DossierService service;


//    @PostMapping(path = "/create")
//    public boolean addDossier(@RequestBody PersonnelDossierScanModel model) {
//        return service.create(model);
//    }

    @PostMapping(path = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public boolean createDossier(@RequestParam MultipartFile image,PersonnelDossierScanModel model) {
        return service.create(image,model);
    }


    @PutMapping(path = "/Update/{id}")
    public boolean updateDossier(@RequestParam Integer id, PersonnelDossierScanModel model) {
        return service.update(id,model);
    }

    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteDossier(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/All")
    public List<PersonnelDossierScanModel> getAllDossier() {
        return service.findAll();
    }

    @GetMapping(path = "/ById/{id}")
    public PersonnelDossierScanModel getDossierById(@PathVariable Integer id) {
        return service.find(id);
    }

    @GetMapping(path = "/ByAgent")
    public List<PersonnelDossierScanModel> getDossierByAgent(@PathVariable int IDagent) {
        return service.findByAgent(IDagent);
    }
    @GetMapping(path = "/image/{id}",produces={MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
    public byte[] getImageFold(@PathVariable int id) throws DataFormatException, IOException {
        PersonnelDossierScanModel dbImage = this.getDossierById(id);
        return dbImage.getImagFold();
    }
}
