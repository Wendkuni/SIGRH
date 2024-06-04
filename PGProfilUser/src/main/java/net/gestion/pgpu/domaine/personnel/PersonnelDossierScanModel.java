package net.gestion.pgpu.domaine.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelDossierScanModel {

    private long idDossierScan;
    private PersonnelModel personnel;
    private String libelDossier;
    private LocalDate dateUpload;
    private String observvation;
   // private ???  imageFold;

}
