package net.gestion.pgpu.domaine.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonnelFormationModel  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFormation;
	private PersonnelModel personnel;
	private String libFormation;
	private LocalDateTime dateDebut;
	private LocalDateTime dateFin;
	private String finaltef;
	private String lieuFormation;
	

}
