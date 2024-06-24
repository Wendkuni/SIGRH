package com.sigrh.gestionressourceh.domains.personnel;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
	private LocalDate dateeffet;
	private String signataire;
	private String libelle;
	
	
}
