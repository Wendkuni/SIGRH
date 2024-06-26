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

    @GetMapping(path = "/AllDdren")
    public ResponseEntity<ApiResponse<List<String>>> getAllListeLocalite () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des Dren").result(service.ListeLocalite()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/AllCodeW")
    public ResponseEntity<ApiResponse<List<String>>> getAllCodeW () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des CodeW").result(service.ListeCodew()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/AllCodeMougkata")
    public ResponseEntity<ApiResponse<List<String>>> getAllCodeMougkata () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des CodeMougkata").result(service.ListeCodeMougkata()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

    @GetMapping(path = "/AllPriority")
    public ResponseEntity<ApiResponse<List<String>>> getAllPriority () {
        ApiResponse<List<String>> reponse = new ApiResponse.
                Builder<List<String>>().status(HttpStatus.OK.value())
                .message("Liste des priority").result(service.ListePriority()).build();
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }


}
