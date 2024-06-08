package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParamLoctnModel {
    private long idParamLoctn;
    private  String libeFctn;
    private  String localiteInfo;
    private  int valindeminite;
    private  String libeFctnarab;
    private  String localiteInfoarabe;
}

