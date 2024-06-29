package com.sigrh.gestionressourceh.domains.personnel;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonnelDossierScanModel implements Serializable {

    private static final long serialVersionUID = 1L;
	private long idDossierScan;
    private PersonnelModel personnel;
    private String libelDossier;
    private LocalDate dateUpload;
    private String observation;
    private byte[] imagFold;
    private long refsAffectation;
}
