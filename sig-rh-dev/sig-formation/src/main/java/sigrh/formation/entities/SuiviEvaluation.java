package sigrh.formation.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "suiviEvaluation")
public class SuiviEvaluation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSuiviEvaluation;
	@ManyToOne
	@JoinColumn(name = "agentEvaluation", referencedColumnName = "idAgentEvaluation")
    private AgentEvaluation agentEvaluation;
	@ManyToOne
	@JoinColumn(name = "critere", referencedColumnName = "idCritere")
    private Critere critere;
	private String avis;

}
