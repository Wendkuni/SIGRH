package com.sigrh.gestionressourceh.domains.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonnelModel {
    private long idAgent;
    private String matricule;
    private String nomPrenom;
    private String nomPrenomArab;
    private String nni;
    private Date dteRecrutement;
    private Date dteTitularisation;
    private Date dteSortie;
    private String statusEmp;
    private String tlphone;
    private String adressEmp;
    private Date debutCntrat;
    private Date finCntrat;
    private Date dateNaiss;
    private String lieuNaiss;
    private String actifOrNot;
    private String bank;
    private String codeBank;
    private Integer numroCpte;
    private String cleRib;
    private String detacher;
    private String ministerOrigine;
  
    private TypeEducation Typeeducation;


    public String toString() {
        return nomPrenom +" Mle:"+matricule+" Nni:"+nni;
    }
}
