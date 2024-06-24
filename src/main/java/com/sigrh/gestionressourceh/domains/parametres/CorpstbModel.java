package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CorpstbModel implements Serializable {
    private long idCorpsTb;
    private String libCorps;

}
