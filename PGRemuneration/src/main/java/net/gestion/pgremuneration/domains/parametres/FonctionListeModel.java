package net.gestion.pgremuneration.domains.parametres;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FonctionListeModel implements Serializable {
    private  long idFonctionListe;
    private String libelleFonction;
    private String libelleFonctionArab;
    private String grade;
    private String echelle;
    private double salaireBase;
    private String indixe;
    private String echelon;
}
