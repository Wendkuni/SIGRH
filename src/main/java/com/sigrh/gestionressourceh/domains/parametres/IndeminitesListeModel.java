package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndeminitesListeModel implements Serializable {
    private long idIndeminites;
    private String libelleIndeminite;

}
