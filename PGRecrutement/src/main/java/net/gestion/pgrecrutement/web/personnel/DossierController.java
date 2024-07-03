package net.gestion.pgrecrutement.web.personnel;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.gestion.pgrecrutement.domains.personnel.PersonnelDossierScanModel;
import net.gestion.pgrecrutement.services.DTO.DossierDTO;
import net.gestion.pgrecrutement.services.personnel.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/dossier")
@AllArgsConstructor
public class DossierController {
     
	@Autowired
    DossierService service;
    private final ObjectMapper objectMapper = new ObjectMapper();




    @PostMapping(path = "/create",consumes=MULTIPART_FORM_DATA_VALUE)
    public boolean createDossier(@RequestPart(value = "image") List<MultipartFile> image, @RequestPart(value = "dossier") String dossier) {
        try {
            objectMapper.findAndRegisterModules();
            DossierDTO model = objectMapper.readValue(dossier, DossierDTO.class);
            return service.create(image,new DossierDTO().toDossierScanModel(model));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    
    @PutMapping(path = "/Update/{id}",consumes=MULTIPART_FORM_DATA_VALUE)
    public boolean updateDossier(@RequestPart(value = "image") MultipartFile image,@RequestParam Integer id, DossierDTO model) throws IOException {
    	PersonnelDossierScanModel doc = new DossierDTO().toDossierScanModel(model);
        doc.setImagFold((image.getBytes()));
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

    @GetMapping(path = "/ByAgent/{IDagent}")
    public List<PersonnelDossierScanModel> getDossierByAgent(@PathVariable int IDagent) {
        return service.findByAgent(IDagent);
    }
   /* @GetMapping(path = "/image/{id}",produces={APPLICATION_PDF_VALUE,IMAGE_PNG_VALUE,IMAGE_JPEG_VALUE})
    public byte[] getImageFold(@PathVariable int id) throws DataFormatException, IOException {
        PersonnelDossierScanModel dbImage = this.getDossierById(id);
        return (dbImage.getImagFold());
    }

    */
    @GetMapping("/images/{id}")
    public ResponseEntity<Map<String, Object>> getImage(@PathVariable int id) {
        try {
            Map<String, Object> images = service.getImages(id);
            return new ResponseEntity<>(images, HttpStatus.OK);
        } catch (DataFormatException | IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
