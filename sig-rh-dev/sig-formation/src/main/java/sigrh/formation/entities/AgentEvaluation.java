package sigrh.formation.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "agentEvaluation")
public class AgentEvaluation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToMany(targetEntity=Theme.class)
    private List<Theme> theme;

}
