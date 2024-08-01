package com.sigrh.gestionressourceh.services.dtos.personnel;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hpsf.Array;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile imagFold;
    
    
    public PersonnelDossierScanModel toDossierScanModel(DossierDTO dto) {
    	try {
			return PersonnelDossierScanModel.builder()
					.dateUpload(dto.getDateUpload())
					.idDossierScan(dto.getIdDossierScan())
					.libelDossier(dto.getLibelDossier())
					.observation(dto.getObservation())
					.imagFold(dto.getImagFold().getBytes())
					.personnel(PersonnelModel.builder().idAgent(dto.getIdAgent()).build())
					.build();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
			
			
		}
    }
    
    public List<PersonnelDossierScanModel> toListDossier(List<DossierDTO> dtos) {
    	
    	List<PersonnelDossierScanModel> dossiers=new ArrayList<>();
    	dtos.stream().forEach(dto->{
				try {
					dossiers.add(PersonnelDossierScanModel.builder()
							.dateUpload(dto.getDateUpload())
							.idDossierScan(dto.getIdDossierScan())
							.libelDossier(dto.getLibelDossier())
							.observation(dto.getObservation())
							.imagFold(dto.getImagFold().getBytes())
							.personnel(PersonnelModel.builder().idAgent(dto.getIdAgent()).build())
							.build());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		});
    	
    	return dossiers;
    	
    }

}
