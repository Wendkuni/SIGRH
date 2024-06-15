package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

import java.io.Serializable;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class GradeModel implements Serializable {
    private long idGrade;
    private String groupe;
    private String categorie;
    private String echellon;
    private String echele;
    private int indiceA;
}
