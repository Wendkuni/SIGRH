package com.sigrh.gestionressourceh.domains.utlisateur;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtlisateurModel {
    private long idUtilsateur;
    private String loginA;
    private String nomPrenom;
    private String droitA;
    private String passwd;
}
