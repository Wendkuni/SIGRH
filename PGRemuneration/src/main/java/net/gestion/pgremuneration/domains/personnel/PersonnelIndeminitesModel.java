package net.gestion.pgremuneration.domains.personnel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonnelIndeminitesModel {


    private long idIndeminites;
    private PersonnelModel personnel;
    private String libIdnmite;
    private int valIndeminite;
    private LocalDate datEffet;
    private String etatAct;
    private int encours;
}