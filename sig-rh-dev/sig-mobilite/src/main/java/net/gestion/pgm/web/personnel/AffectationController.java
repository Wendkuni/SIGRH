package net.gestion.pgm.web.personnel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import net.gestion.pgm.common.ApiResponse;
import net.gestion.pgm.common.constant.TypeNature;
import net.gestion.pgm.domains.personnel.PersonnelAffectationModel;
import net.gestion.pgm.domains.personnel.PersonnelDossierScanModel;
import net.gestion.pgm.domains.personnel.PersonnelFonctionModel;
import net.gestion.pgm.services.dtos.personnel.AffectationDTO;
import net.gestion.pgm.services.dtos.personnel.DossierDTO;
import net.gestion.pgm.services.personnel.AffectationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

import static org.springframework.http.MediaType.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "affectation")
@AllArgsConstructor
public class AffectationController {
     AffectationService service;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(path = "/createAffectation",consumes =MULTIPART_FORM_DATA_VALUE)
    public boolean create(@ModelAttribute AffectationDTO affectation, String matricule) {
          try {
              System.out.println("Received request with affectation: " + affectation);

              objectMapper.findAndRegisterModules();
              PersonnelAffectationModel model = new AffectationDTO().toAffectationModel(affectation);
              if(model.getNature()!= TypeNature.PERMUTATION){
                  return service.create(affectation.getDocuments(), model);
              }else return service.createPermutatation(affectation.getDocuments(), model, matricule);

          } catch (IOException e) {
              throw new RuntimeException("Failed to create affectation", e);
          }


    }


    @PutMapping(path = "/updateAff/{id}")
    public boolean updateAffectation(@RequestParam Integer id, @ModelAttribute AffectationDTO affectation) {
        return service.update(id,affectation);
    }


    @DeleteMapping(path = "/delete/{id}")
    public boolean deleteAffectation(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping(path = "/All")
    public List<PersonnelAffectationModel> getAllAffectation() {
        return service.findAll();
    }

    @GetMapping(path = "/ById/{id}")
    public PersonnelAffectationModel getAffectationById(@PathVariable Integer id) {
        return service.find(id);
    }

    @GetMapping(path = "/ByAgent/{IDagent}")
    public List<PersonnelAffectationModel> getAffectationByAgent(@PathVariable Integer IDagent) {
        return service.findByAgent(IDagent);
    }

    @GetMapping(path = "/TypeNature")
    public ResponseEntity<ApiResponse<List<String>>> getAllTypeNature(){
        List<String> types = Arrays.stream(TypeNature.values()).map(e->e.toString().toUpperCase()).toList();
        ApiResponse<List<String>> response=new ApiResponse.Builder<List<String>>().
                status(HttpStatus.OK.value())
                .message("Liste des types nature").result(types).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping(path = "/images",produces = {APPLICATION_PDF_VALUE, IMAGE_PNG_VALUE,IMAGE_JPEG_VALUE})
    public List<byte[]> getImages(@RequestPart(value = "affectation") String affectation){
        try {
            objectMapper.findAndRegisterModules();
            PersonnelAffectationModel model = objectMapper.readValue(affectation, PersonnelAffectationModel.class);
            return this.service.getImages(model);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping(path = "/Alldossiers")
    public ResponseEntity<ApiResponse<List<PersonnelDossierScanModel>>> getDossiersAffectations(@RequestPart(value = "affectation") String affectation) {
        objectMapper.findAndRegisterModules();
        PersonnelAffectationModel model;
        try {
            model = objectMapper.readValue(affectation, PersonnelAffectationModel.class);
            ApiResponse<List<PersonnelDossierScanModel>> response= new ApiResponse.
                    Builder<List<PersonnelDossierScanModel>>()
                    .message((" liste des dossiers d'affectation"))
                    .result(service.getDossierAffectation(model))
                    .status(HttpStatus.OK.value())
                    .build();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

   /* @PostMapping("/calculer-ponderation")
    public ResponseEntity<Float> calculerPonderation(@RequestBody PersonnelAffectationModel affectation,
                                                     @RequestParam TypeAffectation typeAffectation, List<CritereAffectation> criteres) {
        float ponderation = service.calculerPonderation(affectation, typeAffectation, criteres);
        return ResponseEntity.ok(ponderation);
    }

    */

    @PostMapping("/calculer-ponderation/convenance-personnel")
    public float calculerPonderationConvenancePersonnel(@RequestBody PersonnelAffectationModel affectation) {
        if (affectation.getNature() == TypeNature.PERSONNEL) {
            return service.calculerPonderationC(affectation);
        } else {
            throw new IllegalArgumentException("TypeNature must be CONVENANCE_PERSONNEL");
        }
    }

    /*@PostMapping("/ByPermutation")
    public boolean permutation(@RequestBody PersonnelAffectationModel affectation, String matricule) {
        if (affectation.getNature()== TypeNature.PERMUTATION ) {
            return service.createPermutatation(matricule);
        }
        throw new IllegalArgumentException("L'utilisateur doit avoir plus de 3 ans dans la fonction publique pour bénéficier d'une permutation.");
    }

     */
    @PostMapping("/calculer-ponderation/nomination")
    public float calculerPonderationNomination(@RequestBody PersonnelAffectationModel affectation) {
        if (affectation.getNature() == TypeNature.NOMINATION) {
            return service.calculerPonderationN(affectation);
        } else {
            throw new IllegalArgumentException("TypeNature must be NOMINATION");
        }
    }
}
