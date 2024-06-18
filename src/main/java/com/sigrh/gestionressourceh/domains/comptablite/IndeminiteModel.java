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
public class IndeminiteModel implements Serializable {
    private long idIndeminites;
    private String libelleIndeminite;
    private Integer valeurIndeminite;
    private Date dateEffet;
    private Boolean encours;
    private String etatact;
    private  String fctionLibelle;
    private String grade;
    private PersonnelModel personnel;
}
