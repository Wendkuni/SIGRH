package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelDossierScanModel {

    private long idDossierScan;
    private PersonnelModel personnel;
    private String libelDossier;
    private Date dateUpload;
    private String observation;
    private String imageFold;

}
