package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class GradeModel {
    private long idGrade;
    private String groupe;
    private String categorie;
    private String echellon;
    private String echele;
    private int indiceA;
}
