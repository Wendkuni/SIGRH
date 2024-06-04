package net.gestion.pgpu.domaine.personnel;


import lombok.*;
import net.gestion.pgpu.common.constant.TypeEducation;

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
    private String nomPrenom;
    private String nni;
    private LocalDateTime dteRecrutement;
    private LocalDateTime dteTitularisation;
    private LocalDateTime dteSortie;
    private String statusEmp;
    private String tlphone;
    private String adrssEmp;
    private LocalDate debuCntrat;
    private LocalDate finCntrat;
    private LocalDateTime dateNaiss;
    private String lieuNaiss;
    private String actiformot;
    private String bank;
    private String codeBank;
    private Integer numroCpte;
    private String cleRib;
    private String detacher;
    private String ministerOrigine;
    private TypeEducation typeEducation;

    @Override
    public String toString() {
        return nomPrenom+" Mle:"+matricule+" Nni:"+nni;
    }
}
