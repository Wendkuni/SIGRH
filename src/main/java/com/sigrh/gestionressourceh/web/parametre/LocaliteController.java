package com.sigrh.gestionressourceh.web.parametre;

import com.sigrh.gestionressourceh.domains.parametres.LocaliteModel;

import com.sigrh.gestionressourceh.services.parametre.LocaliteService;
import lombok.AllArgsConstructor;
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


}
