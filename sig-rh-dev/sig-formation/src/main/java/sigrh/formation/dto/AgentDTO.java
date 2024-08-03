package sigrh.formation.dto;

import java.util.Date;

import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.Ecole;
import sigrh.formation.entities.Theme;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentDTO {
	
	private Integer idAgent;
	private String matricule;
    private String nom;
    private String prenom;
    private String sexe;
    private Date dateNaissance;
    private String diplomeAcademique;
    private String diplomeProfessionel;
    private Theme theme;
    private Ecole ecole;

}
