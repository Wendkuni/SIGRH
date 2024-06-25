package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocaliteModel implements Serializable {
    private long idLocalite;
    private String libLocalite;
    private String dDren;
    private String province;
    private String zoneL;
    private String libLocaliteArab;
    private String dDrenwaliah;
    private String provinceArab;
    private String zoneLArab;
    private int codew;
    private int codemougkata;
    private int priority;
    private int nombreDePoint;

}
