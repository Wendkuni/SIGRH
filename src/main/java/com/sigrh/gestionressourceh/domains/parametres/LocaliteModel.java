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
    private String ddren;
    private String province;
    private String zonel;
    private String liblocaliteArab;
    private String ddrenwaliah;
    private String provincearab;
    private String zonelArab;
}
