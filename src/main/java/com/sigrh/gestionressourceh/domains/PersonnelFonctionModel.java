package com.sigrh.gestionressourceh.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonnelFonctionModel  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idFonction;
	private PersonnelModel personnel;
	private String libelleFonction;
	private String echelle;
	private String echelon;
	private String categorie;
	private String groupe;
	private String corps;
	private String grade;
	private LocalDateTime dateDebFonction;
	private String corpsArab;
	private String libelleFonctionArab;
	private String indixe;
	

}
