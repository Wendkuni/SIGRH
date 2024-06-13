package com.sigrh.gestionressourceh.domains.comptablite;

import com.sigrh.gestionressourceh.common.constant.FonctionListe;
import com.sigrh.gestionressourceh.domains.parametres.FonctionListeModel;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor@Builder
public class ConfigIdemit {
    private long idConfigIdemit;
    private FonctionListe fonctionListe;
    private String libIdnmite;
    private Boolean valIdeminite;
    private Date dateCreat;
}

