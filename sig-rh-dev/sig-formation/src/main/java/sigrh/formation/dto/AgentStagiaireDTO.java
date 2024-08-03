package sigrh.formation.dto;

import java.util.Date;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.Ecole;


@Data
@AllArgsConstructor 
@NoArgsConstructor
public class AgentStagiaireDTO {
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
    private Ecole ecole;

}
