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

public class PersonnelAssurancesModel {


    private long idAssurances;
    private PersonnelModel personnel;
    private String tupeAssurance;
    private String liblAssurance;
    private LocalDate debutAssurance;
    private LocalDate finAssurance;
    private String etatAct;

}
