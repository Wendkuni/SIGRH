package com.sigrh.gestionressourceh.domains.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeNature;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonnelAffectationModel implements Serializable {

    private Long idAffectation;
    private PersonnelModel personnel;
    private String localite;
    private String serviceEcole;
    private LocalDate dateEffet ;
    private String dren;
    private double notePedagogiq;
    @Enumerated(EnumType.STRING)
    private TypeNature nature;
    private String motif;
    private String situationSanit;
    private byte[] imgSanit;
    private String libelDos;
    private byte[] imgDos;
    private Integer nombreFant;
    private Integer ancieneteGen;
    private Integer ancienetePoste;
    private String posteOrigin;
    private String posteDestinat1;
    private String posteDestinat2;
    private String posteDestinat3;




}