package net.gestion.pgm.domains.personnel;

import lombok.*;
import net.gestion.pgm.common.constant.TypeDistinction;
import net.gestion.pgm.common.constant.TypeNature;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
    private String posteDestinat4;
    private String posteDestinat5;
    @Enumerated(EnumType.STRING)
    private TypeDistinction distinction;
    private String regroupementConjoint;
    private String autresSocial;
    private int noteAdministrative;
    private String situationMatrimo;
    private String etatAffect;
    private float pointsPondere;
    private String autresDiplome;
    private LocalDate dateDemande;
    private String destinationRetenue;
    private String appreciation;




}


