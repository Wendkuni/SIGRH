package net.gestion.pgrecrutement.web.personnel;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import net.gestion.pgrecrutement.common.ApiResponse;
import net.gestion.pgrecrutement.common.constant.TypeEducation;
import net.gestion.pgrecrutement.domains.personnel.PersonnelModel;
import net.gestion.pgrecrutement.services.personnel.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

import static org.springframework.http.MediaType.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api/personnel")
@AllArgsConstructor
public class PersonnelController  {
    @Autowired
    private PersonnelService service;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping(path = "/create",consumes =MULTIPART_FORM_DATA_VALUE)
    public boolean createPersonnel(@RequestPart(value = "image") MultipartFile image, @RequestPart(value = "personnel") String personnel) {
        try {
            objectMapper.findAndRegisterModules();
            PersonnelModel model = objectMapper.readValue(personnel, PersonnelModel.class);
            return service.create(image, model);
        } catch (IOException e) {
            throw new RuntimeException("Failed to create personnel", e);
        }
    }



    @PutMapping(path = "/updade/{id}",consumes =MULTIPART_FORM_DATA_VALUE)
    public boolean updatePersonnel(@RequestPart(value = "image") MultipartFile image,@PathVariable Integer id, PersonnelModel model) throws IOException {
    	model.setImagPers(image.getBytes());
        return service.update(id,model);
    }



    @DeleteMapping(path = "/delete/{id}")
    public boolean deletePersonnel(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/All")
    public List<PersonnelModel> getAllPersonnel() {
        return service.findAll();
    }

    @GetMapping(path = "/ById/{id}")
    public PersonnelModel getPersonnelById(@PathVariable Integer id) {
        return service.find(id);
    }

    @GetMapping(path = "/ByMatricule/{matricule}")
    public PersonnelModel getPersonnelByMatricule(@PathVariable String matricule) {
        return service.findByMatricul(matricule);
    }

    @GetMapping(path = "/ByAffectation/{id}")
    public List<PersonnelModel> getAllPersonnelByAffectation(@PathVariable Integer id) {
        return service.findByAffectation(id);
    };

    @GetMapping(path = "/ByLocalite/{libelle}")
    public List<PersonnelModel> getAllPersonnelByLocalite(@PathVariable String libelle) {
        return service.findByLocalite(libelle);
    }

    @GetMapping(path = "/TypeEducations")
    public ResponseEntity<ApiResponse<List<String>>> getAllTypeEducation(){
        List<String> types = Arrays.stream(TypeEducation.values()).map(e->e.toString().toUpperCase()).toList();
        ApiResponse<List<String>> response=new ApiResponse.Builder<List<String>>().
        status(HttpStatus.OK.value())
                .message("Liste des types éducation").result(types).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }



    @GetMapping(path = "/image/{id}",produces = {IMAGE_PNG_VALUE,IMAGE_JPEG_VALUE})
    public byte[] getImage(@PathVariable int id){
        try {
           return this.service.getImage(id);
        } catch (DataFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
