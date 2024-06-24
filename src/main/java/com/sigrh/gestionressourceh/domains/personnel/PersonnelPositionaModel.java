package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelPositionaModel {

    private long idPostiona;
    private PersonnelModel personnel;
    private String refernces;
    private LocalDate dateEffect;
    private String libelPosition;

}
