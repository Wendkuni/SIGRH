package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelRenumerationAgentModel {

    private long idRenumerationAgent;
    private PersonnelModel personnel;
    private double valmnt;
    private String bankLib;
    private Date dateEffet;
}
