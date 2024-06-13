package com.sigrh.gestionressourceh.domains.comptablite;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RenumerationAgent {
    private Long idRenumeration;
    private Date dateEffet;
    private  String libeellleBank;
    private  String codeBank;
    private Double valeurMontant;
    private PersonnelModel personnel;
}
