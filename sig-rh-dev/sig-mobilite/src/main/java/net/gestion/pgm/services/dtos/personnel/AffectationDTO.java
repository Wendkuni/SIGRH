package net.gestion.pgm.services.dtos.personnel;


import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import net.gestion.pgm.common.constant.TypeDistinction;
import net.gestion.pgm.common.constant.TypeNature;
import net.gestion.pgm.domains.personnel.PersonnelAffectationModel;
import net.gestion.pgm.domains.personnel.PersonnelModel;
import org.springframework.web.multipart.MultipartFile;


import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AffectationDTO {
	private Long idAffectation;
    private PersonnelModel agent;
    private PersonnelModel agent2;

    private String localite;
    private String serviceEcole;
    private LocalDate dateEffet ;
    private String dren;
    private double notePedagogiq;

    @Enumerated(EnumType.STRING)
    private TypeNature nature;
    private String motif;
    private String situationSanit;
    private byte[] imgSanit;
    private String libelDos;
    private byte[] imgDos;
    private Integer nombreFant;
    private Integer ancieneteGen;
    private Integer ancienetePoste;
    private String posteOrigin;
    private String posteDestinat1;
    private String posteDestinat2;
    private String posteDestinat3;
    private String posteDestinat4;
    private String posteDestinat5;

    @Enumerated(EnumType.STRING)
    private TypeDistinction distinction;
    private String regroupementConjoint;
    private String autresSocial;
    private int noteAdministrative;
    private String situationMatrimo;

    private String etatAffect;
    private float pointsPondere;
    private String autresDiplome;
    private LocalDate dateDemande;

    private String destinationRetenue;
    private String appreciation;    
    private List<MultipartFile> documents;
    
    public PersonnelAffectationModel toAffectationModel(AffectationDTO dto) {
    	return PersonnelAffectationModel.builder()
                .idAffectation(dto.getIdAffectation())
                .dateEffet(dto.getDateEffet())
                .dren(dto.getDren())
                .localite(dto.getLocalite())
                .notePedagogiq(dto.getNotePedagogiq())
                .agent(dto.getAgent())
                .agent2(dto.getAgent2())
                .serviceEcole(dto.getServiceEcole())
                .motif(dto.getMotif())
                .nature(dto.getNature())
                .situationSanit(dto.getSituationSanit())
                .imgSanit(dto.getImgSanit())
                .libelDos(dto.getLibelDos())
                .imgDos(dto.getImgDos())
                .nombreFant(dto.getNombreFant())
                .ancieneteGen(dto.getAncieneteGen())
                .ancienetePoste(dto.getAncienetePoste())
                .posteOrigin(dto.getPosteOrigin())
                .posteDestinat1(dto.getPosteDestinat1())
                .posteDestinat2(dto.getPosteDestinat2())
                .posteDestinat3(dto.getPosteDestinat3())
                .posteDestinat4(dto.getPosteDestinat4())
                .posteDestinat5(dto.getPosteDestinat5())
                .distinction(dto.getDistinction())
                .regroupementConjoint(dto.getRegroupementConjoint())
                .autresSocial(dto.getAutresSocial())
                .noteAdministrative(dto.getNoteAdministrative())
                .situationMatrimo(dto.getSituationMatrimo())
                .etatAffect(dto.getEtatAffect())
                .pointsPondere(dto.getPointsPondere())
                .autresDiplome(dto.getAutresDiplome())
                .dateDemande(dto.getDateDemande())
                .destinationRetenue(dto.getDestinationRetenue())
                .appreciation(dto.getAppreciation())
                .build();
    }
}
