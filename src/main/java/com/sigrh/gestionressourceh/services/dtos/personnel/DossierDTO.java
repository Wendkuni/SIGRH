package com.sigrh.gestionressourceh.services.dtos.personnel;

import java.time.LocalDate;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DossierDTO {
	private long idDossierScan;
    private long idAgent;
    private String libelDossier;
    private LocalDate dateUpload;
    private String observation;
    private byte[] imagFold;
    
    
    public PersonnelDossierScanModel toDossierScanModel(DossierDTO dto) {
    	return PersonnelDossierScanModel.builder()
    			.dateUpload(dto.getDateUpload())
    			.idDossierScan(dto.getIdDossierScan())
    			.libelDossier(dto.getLibelDossier())
    			.observation(dto.getObservation())
    			.imagFold(dto.getImagFold())
    			.personnel(PersonnelModel.builder().idAgent(dto.getIdAgent()).build())
    			.build();
    }

}
