package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FonctionListeModel {
    private  long idFonctionListe;
    private String libFonctn;
    private String libFonctnarab;
    private String garde;
    private String echelle;
    private double salbase;
    private String indixe;
    private String echelon;
}
