package net.gestion.pgpu.domaine.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonnelAbsenceModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idAbsence;
	private PersonnelModel personnel;
	private String autorisation;
	private String motif;
	private int nbJour;
	private String dateDebut;
	private String dateFin;
	private String libelle;
	
	
}
