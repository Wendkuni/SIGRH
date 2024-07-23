package com.sigrh.gestionressourceh.domains.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeDistinction;
import com.sigrh.gestionressourceh.common.constant.TypeNature;
import lombok.*;

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
    private Integer ancieneteFonctionPublic;
    private Integer ancieneteAdminScolaire;
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

    public void calculerPonderation(){
        /*
            Ancienete Fonction Public
         * */
        if (getAncieneteFonctionPublic() != null && getAncieneteFonctionPublic() >= 4)
            this.pointsPondere += (float) ((getAncieneteFonctionPublic() - 3) * 0.5);
        /*
            Discrimination positive
         * */
        if (getPersonnel() != null && "FEMININ".equalsIgnoreCase(getPersonnel().getSexePers()))
            this.pointsPondere += 5;

        /*
            Note Pédagogique
         * */
        this.pointsPondere += (float) getNotePedagogiq();

         /*
            Notes administratives
         * */
        this.pointsPondere += getNoteAdministrative();

        /*
            Distinction
         * */
        switch (this.distinction){
            case NATIONALE:
                this.pointsPondere += 10;
                break;
            case REGIONALE:
                this.pointsPondere += 8;
                break;
            case DEPARTEMENTALE:
                this.pointsPondere += 5;
                break;
        }

        /*

         * */
        switch (this.nature){
            case PERSONNEL:
                /*
                    Nombre d'enfants
                 * */
                if (getNombreFant() != null)
                    this.pointsPondere += (getNombreFant() >= 5)?10:(getNombreFant() * 2);
                /*
                    Regroupement de conjoints
                 * */
                if (getRegroupementConjoint() != null)
                    this.pointsPondere += 10;
                /*
                    Autres situations sociales
                 * */
                if (getAutresSocial() != null)
                    this.pointsPondere += 5;
                /*
                    Situation Sanitaire
                 * */
                if (getSituationSanit() != null)
                    this.pointsPondere += 10;
                /*
                    Ancieneté willaya / Moughataa / enclavement de
                    l’établissement secondaire
                 * */
                if (getAncieneteGen() != null) {
                    if (getAncieneteGen() >= 15)
                        this.pointsPondere += 15;
                    else
                        this.pointsPondere += getAncieneteGen();
                }
                /*
                    Zone géographique
                 * */
                switch (this.localite){
                    case "Nouakchott Nord":
                    case "Nouakchott Ouest":
                    case "Nouakchott Sud":
                        this.pointsPondere += 0;
                        break;
                    case "Trarza":
                    case "Inchiri":
                    case "D. Nouadhibou":
                        this.pointsPondere += 1;
                        break;
                    case "Brakna":
                    case "Adrar":
                    case "Tiris Zemour":
                        this.pointsPondere += 4;
                        break;
                    case "Gorgol":
                    case "Assaba":
                    case "Hodh Gharbi":
                        this.pointsPondere += 8;
                        break;
                    case "H. Charghi":
                    case "Guidimakha":
                    case "Tagant":
                        this.pointsPondere += 10;
                        break;
                }
                break;

            case NOMINATION:
                /*
                    Ancienneté dans le poste de travail
                 * */
                if (getAncienetePoste() != null) {
                    if (getAncienetePoste() >= 15)
                        this.pointsPondere += 15;
                    else
                        this.pointsPondere += getAncienetePoste();
                }
                  /*
                    Ancienneté dans l'administration Scolaire
                 * */


                  /*
                    Autres diplômes et certifications
                 * */
                if (getAutresDiplome() != null) {
                    switch (getAutresDiplome()) {
                        case "bac+8":
                        case "bac+7":
                        case "bac+6":
                        case "bac+5":
                            this.pointsPondere += 10;
                            break;
                        case "bac+3":
                            this.pointsPondere += 8;
                            break;
                        default:
                            this.pointsPondere += 5;
                            break;
                    }
                }
                break;

        }
    }
}
