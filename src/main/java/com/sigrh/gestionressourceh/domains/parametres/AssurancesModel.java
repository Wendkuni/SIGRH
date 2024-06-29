package com.sigrh.gestionressourceh.domains.parametres;

import com.sigrh.gestionressourceh.common.constant.TypeAssurance;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AssurancesModel implements Serializable {
	
    private static final long serialVersionUID = 1L;
	private Long idAssurance;
    private PersonnelModel personnel;
    private String etatact;
    private String libelleAssurance;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    private TypeAssurance typeAssurance;
}
