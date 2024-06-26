package com.sigrh.gestionressourceh.web.parametre;

import com.sigrh.gestionressourceh.common.ApiResponse;
import com.sigrh.gestionressourceh.domains.parametres.LocaliteModel;

import com.sigrh.gestionressourceh.services.parametre.LocaliteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/v1/api")
@AllArgsConstructor
public class LocaliteController {
    LocaliteService service;


    @GetMapping("/localites")
    public List<LocaliteModel> findAll() {
        return service.findAll();
    }

    @GetMapping(path = "/affectationByLocalite")
    public ResponseEntity<ApiResponse<List<String>>> getAllListeLocalite () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des echelons").result(service.ListeLocalite()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }


}
