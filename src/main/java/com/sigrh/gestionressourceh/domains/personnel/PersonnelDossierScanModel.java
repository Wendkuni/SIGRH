package com.sigrh.gestionressourceh.domains.personnel;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonnelDossierScanModel {

    private long idDossierScan;
    private PersonnelModel personnel;
    private String libelDossier;
    private Date dateUpload;
    private String observation;
    private byte[] imagFold;

}
