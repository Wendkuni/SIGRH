package com.sigrh.gestionressourceh.domains.comptablite;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RenumerationAgentModel implements Serializable {
    private Long idRenumeration;
    private Date dateEffet;
    private  String libelleBank;
    private  String codeBank;
    private Double valeurMontant;
    private PersonnelModel personnel;
}
