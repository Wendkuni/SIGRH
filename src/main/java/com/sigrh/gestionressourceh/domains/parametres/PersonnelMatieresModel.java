package com.sigrh.gestionressourceh.domains.parametres;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PersonnelMatieresModel {

    private long idMatieres;
    private PersonnelModel personnel;
    private String libMatiere;

}
