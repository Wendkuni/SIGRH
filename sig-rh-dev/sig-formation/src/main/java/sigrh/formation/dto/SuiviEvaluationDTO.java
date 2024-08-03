package sigrh.formation.dto;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.AgentEvaluation;
import sigrh.formation.entities.Critere;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuiviEvaluationDTO {
	
	private Integer idSuiviEvaluation;
    private AgentEvaluation agentEvaluation;
    private Critere critere;
    private String avis;

}
