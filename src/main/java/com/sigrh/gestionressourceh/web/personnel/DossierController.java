package com.sigrh.gestionressourceh.web.personnel;


import com.sigrh.gestionressourceh.common.util.ImageUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import com.sigrh.gestionressourceh.services.dtos.personnel.DossierDTO;
import com.sigrh.gestionressourceh.services.personnel.DossierService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import static  org.springframework.http.MediaType.APPLICATION_PDF_VALUE;
import static  org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;
import static  org.springframework.http.MediaType.IMAGE_JPEG_VALUE;
import static  org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/dossier")
@AllArgsConstructor
public class DossierController {
     
	@Autowired
    DossierService service;


//    @PostMapping(path = "/create")
//    public boolean addDossier(@RequestBody PersonnelDossierScanModel model) {
//        return service.create(model);
//    }
    
//  @PutMapping(path = "/Update/{id}")
//  public boolean updateDossier(@RequestParam Integer id, PersonnelDossierScanModel model) {
//      return service.update(id,model);
//  }   

    @PostMapping(path = "/create",consumes=MULTIPART_FORM_DATA_VALUE)
    public boolean createDossier(@RequestPart(value = "image") MultipartFile image, DossierDTO model) {
        return service.create(image,new DossierDTO().toDossierScanModel(model));
     }
    
    @PutMapping(path = "/Update/{id}",consumes=MULTIPART_FORM_DATA_VALUE)
    public boolean updateDossier(@RequestPart(value = "image") MultipartFile image,@RequestParam Integer id, DossierDTO model) throws IOException {
    	PersonnelDossierScanModel doc = new DossierDTO().toDossierScanModel(model);
        doc.setImagFold(ImageUtil.compressImage(image.getBytes()));
    	return service.update(id,doc);
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
    @GetMapping(path = "/image/{id}",produces={APPLICATION_PDF_VALUE,IMAGE_PNG_VALUE,IMAGE_JPEG_VALUE})
    public byte[] getImageFold(@PathVariable int id) throws DataFormatException, IOException {
        PersonnelDossierScanModel dbImage = this.getDossierById(id);
        return ImageUtil.decompressImage(dbImage.getImagFold());
    }
}
