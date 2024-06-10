package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


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
	private Date dateDebut;
	private Date dateFin;
	private String libelle;
	
	
}
