package net.gestion.pgm.domains.personnel;

import lombok.*;
import net.gestion.pgm.common.constant.TypeNature;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.time.LocalDate;

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
