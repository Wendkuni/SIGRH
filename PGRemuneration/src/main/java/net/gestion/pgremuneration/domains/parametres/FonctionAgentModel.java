package net.gestion.pgremuneration.domains.parametres;


import lombok.*;
import net.gestion.pgremuneration.domains.personnel.PersonnelModel;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FonctionAgentModel implements Serializable {
    private long idFonctionAgent;
    private PersonnelModel personnel;
    private String foctionLib;
    private LocalDate dateFonctio;
    private String echelle;
    private String echelon;
    private String groupA;
    private String categoriA;
    private String corpsA;
    private String grade;
    private String indixe;
    private String corpsAarab;
    private String fonctionLiarab;

}
