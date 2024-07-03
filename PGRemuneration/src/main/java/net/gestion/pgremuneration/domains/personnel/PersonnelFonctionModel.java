package net.gestion.pgremuneration.domains.personnel;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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
	private LocalDate dateDebFonction;
	private String corpsArab;
	private String libelleFonctionArab;
	private String indixe;
	

}
