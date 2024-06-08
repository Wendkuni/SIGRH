package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelAllocationFamilleModel {


    private long idAllocationFamille;
    private PersonnelModel personnel;
    private LocalDate dateNaissPrise;
    private String nomePrenomPrise;
    private LocalDate dateEffet;
    private String etatact;
    private String echele;
    private String echelon;
    private String  index;
    private String corspa;
    private String refdecret;
}
