package sigrh.formation.entities;

import java.util.Date;

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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="agentStagiaire")
public class AgentStagiaire {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAgentStagiaire;
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
    private Boolean isValideDren;
    private String motif;
    private String filename;
    private String lieuStage;
    @ManyToOne
    @JoinColumn(name = "ecole", referencedColumnName = "idEcole")
    private Ecole ecole;

}
