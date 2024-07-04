package com.sigrh.gestionressourceh.domains.utlisateur;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListeRoleModel {
     private long idListeRole;
     private String roleLib;
     private int attribuable;
}