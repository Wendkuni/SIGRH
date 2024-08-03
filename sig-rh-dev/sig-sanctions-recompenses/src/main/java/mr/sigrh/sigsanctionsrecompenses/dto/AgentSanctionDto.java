
package mr.sigrh.sigsanctionsrecompenses.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import mr.sigrh.sigsanctionsrecompenses.domaine.AgentSanction;
import mr.sigrh.sigsanctionsrecompenses.domaine.Personnel;
import mr.sigrh.sigsanctionsrecompenses.domaine.Sanction;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
public class AgentSanctionDto {

    private Long id;
    private Boolean statut;  // Changed from primitive boolean to wrapper class Boolean
    private Long idAgent;
    private Long idSanction;

    private MultipartFile demandeExplication;
    private MultipartFile reponseExplication;
    private MultipartFile rapportSuperieur;
    private MultipartFile pvConseilDiscipline;

    private String demandeUrl;
    private String reponseUrl;
    private String rapportUrl;
    private String pvConseilUrl;

    public static AgentSanctionDto fromEntity(AgentSanction agentSanction) {
        return AgentSanctionDto.builder()
                .id(agentSanction.getId())
                .statut(agentSanction.getStatut()) // This remains unchanged as AgentSanction might still use primitive boolean
                .idAgent(agentSanction.getAgent().getId())
                .idSanction(agentSanction.getSanction().getId())
                .demandeUrl(agentSanction.getDemandeExplication())
                .reponseUrl(agentSanction.getReponseExplication())
                .rapportUrl(agentSanction.getRapportSuperieur())
                .pvConseilUrl(agentSanction.getPvConseilDiscipline())
                .build();
    }

    public static AgentSanction toEntity(AgentSanctionDto dto) {
        return AgentSanction.builder()
                .id(dto.getId())
                .statut(dto.getStatut() != null ? dto.getStatut() : false)  // Handle null by defaulting to false
                .agent(Personnel.builder().id(dto.getIdAgent()).build())
                .sanction(Sanction.builder().id(dto.getIdSanction()).build())
                .build();
    }
}
