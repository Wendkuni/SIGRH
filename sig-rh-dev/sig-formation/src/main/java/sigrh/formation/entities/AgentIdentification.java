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
@Table(name="agentIdentifieur")
public class AgentIdentification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAgent;
	private String nn;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sexe;
	private String diplomeAcademique;
	private String diplomeProfessionnel;
	private String dren;
	@ManyToOne
	@JoinColumn(name = "theme", referencedColumnName = "idTheme")
	private Theme theme;
	private String posteActuel;
	private String fonctionActuelle;
	private String autreFormation;
	private Boolean isValideDren;
	private Boolean isValideDrh;
//	private String financement;
//	private String dureeFormation;
//	private String lieuFormation;
	@ManyToOne
	@JoinColumn(name = "ecole", referencedColumnName = "idEcole")
	private Ecole ecole;

}
