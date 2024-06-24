package com.sigrh.gestionressourceh.domains.parametres;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import lombok.*;

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