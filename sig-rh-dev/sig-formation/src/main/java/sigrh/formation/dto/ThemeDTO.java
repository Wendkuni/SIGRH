package sigrh.formation.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.Ecole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThemeDTO {
	
	private Integer idTheme;
	private String code;
	private String intitule;
	private String modalite;
	private String dureeFormation;
	private String lieuFormation;
	private String financement;
	private EcoleDTO ecole;
}
