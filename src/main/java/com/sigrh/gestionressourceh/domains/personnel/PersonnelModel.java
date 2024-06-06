package com.sigrh.gestionressourceh.domains.personnel;

import com.fasterxml.jackson.databind.annotation.EnumNaming;
import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonnelModel {
    private long idAgent;
    private String matricule;
    private String nometprenom;
    private String nometprenomarab;
    private String nni;
    private LocalDateTime dterecrutement;
    private LocalDateTime dtetitularisation;
    private LocalDateTime dtesortie;
    private String statusemp;
    private String tlphone;
    private String adressemp;
    private LocalDate debutcntrat;
    private LocalDate fincntrat;
    private LocalDateTime datenaiss;
    private String lieunaiss;
    private String actifornot;
    private String bank;
    private String codbank;
    private Integer numrocpte;
    private String clerib;
    private String detacher;
    private String ministerorigine;
  
    private TypeEducation Typeeducation;

    @Override
    public String toString() {
        return nometprenom+" Mle:"+matricule+" Nni:"+nni;
    }
}
