package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelAllocationFamilleModel {


    private long idAllocationFamille;
    private PersonnelModel personnel;
    private Date dateNaissPrise;
    private String nomePrenomPrise;
    private Date dateEffet;
    private String etatAct;
    private String echele;
    private String echelon;
    private String  index;
    private String corspa;
    private String refDecret;
}
