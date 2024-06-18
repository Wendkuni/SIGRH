package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParamLoctnModel implements Serializable {
    private long idParamLoctn;
    private  String libeFctn;
    private  String localiteInfo;
    private  int valindeminite;
    private  String libeFctnarab;
    private  String localiteInfoArabe;
}

