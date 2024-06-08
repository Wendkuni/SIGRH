package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParamFnctonModel {
    private long idParamFnctn;
    private  String libFnct;
    private String libIndimorsalbase;
    private int mtvalinit;
}
