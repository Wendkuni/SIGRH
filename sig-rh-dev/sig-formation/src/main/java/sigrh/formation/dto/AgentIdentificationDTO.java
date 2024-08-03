package sigrh.formation.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.Ecole;
import sigrh.formation.entities.Theme;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentIdentificationDTO {
	
	private Integer idAgent;
	private String nn;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String sexe;
	private String diplomeAcademique;
	private String diplomeProfessionnel;
	private String dren;
	private Theme theme;
	private String posteActuel;
	private String fonctionActuelle;
	private String autreFormation;
	private Boolean isValideDren;
	private Boolean isValideDrh;
//	private String financement;
//	private String dureeFormation;
//	private String lieuFormation;
	private Ecole ecole;

}
