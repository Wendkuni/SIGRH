package net.gestion.pgpu.domaine.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelMatieresModel {

    private long idMatieres;
    private PersonnelModel personnel;
    private String libMatiere;

}
