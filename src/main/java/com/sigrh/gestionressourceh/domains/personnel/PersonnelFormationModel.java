package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
	private LocalDate dateeffet;
	private LocalDate dateFin;
	private String finaltef;
	private String lieuFormation;
	

}
