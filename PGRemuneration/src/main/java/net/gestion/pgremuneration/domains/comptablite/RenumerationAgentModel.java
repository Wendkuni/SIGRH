package net.gestion.pgremuneration.domains.comptablite;


import lombok.*;
import net.gestion.pgremuneration.domains.personnel.PersonnelModel;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RenumerationAgentModel implements Serializable {
    private Long idRenumeration;
    private LocalDate dateEffet;
    private  String libelleBank;
    private  String codeBank;
    private Double valeurMontant;
    private PersonnelModel personnel;
}
