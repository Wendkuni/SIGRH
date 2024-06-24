package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParamFnctonModel implements Serializable {
    private long idParamFnctn;
    private  String libFnct;
    private String libIndimorsalbase;
    private int mtvalinit;
}
