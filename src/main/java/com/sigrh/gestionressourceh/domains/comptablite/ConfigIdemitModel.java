package com.sigrh.gestionressourceh.domains.comptablite;

import com.sigrh.gestionressourceh.domains.parametres.FonctionListeModel;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class ConfigIdemitModel implements Serializable {
    private long idConfigIdemit;
    private FonctionListeModel fonctionListe;
    private String libIdnmite;
    private int valIdeminite;
    private Date dateCreat;
}

