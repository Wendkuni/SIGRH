package com.sigrh.gestionressourceh.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PresonnelAffectationModel implements Serializable {

    private Long idAffectation;
    private PersonnelModel personnel;
    private String localite;
    private String serviceEcole;
    private Date dateEffet ;
    private String dren;
    private double notePedagogiq;


}
