package sigrh.formation.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.Theme;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentEvaluationDTO {
	
	private Integer idAgentEvaluation;
    private String dren;
    private String nni;
    private String matricule;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String diplomeAcademique;
    private String diplomeProfessionnel;
    private String posteActuel;
    private String fonctionActuelle;
    private List<Theme> theme;

}
