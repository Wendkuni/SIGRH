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
public class IndeminiteModel implements Serializable {
    private long idIndeminites;
    private String libelleIndeminite;
    private Integer valeurIndeminite;
    private LocalDate dateEffet;
    private Boolean encours;
    private String etatact;
    private String fctionLibelle;
    private String grade;
    private PersonnelModel personnel;
}
