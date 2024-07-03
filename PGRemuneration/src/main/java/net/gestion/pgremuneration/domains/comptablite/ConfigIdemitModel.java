package net.gestion.pgremuneration.domains.comptablite;

import lombok.*;
import net.gestion.pgremuneration.domains.parametres.FonctionListeModel;

import java.io.Serializable;
import java.time.LocalDate;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class ConfigIdemitModel implements Serializable {
    private long idConfigIdemit;
    private FonctionListeModel fonctionListe;
    private String libIdnmite;
    private int valIdeminite;
    private LocalDate dateCreat;
}

