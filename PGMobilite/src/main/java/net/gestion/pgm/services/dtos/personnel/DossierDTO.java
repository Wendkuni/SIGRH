package net.gestion.pgm.services.dtos.personnel;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.gestion.pgm.domains.personnel.PersonnelDossierScanModel;
import net.gestion.pgm.domains.personnel.PersonnelModel;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;


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
            throw new RuntimeException(e);
        }
    }

}
