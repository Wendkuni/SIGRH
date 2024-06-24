package com.sigrh.gestionressourceh.domains.parametres;

import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter@NoArgsConstructor@AllArgsConstructor@Builder
public class EcolesModel implements Serializable {
    private long idEcoles;
    private String libEcoles;
    private String zonel;
    private String ddren;
    private TypeEducation typeEducation;
    private String libEcolesArab;
    private String zonelarab;
    private String ddrenwallah;
    private String moughataaarab;
    private String moughataa;
    private String typeeducationarab;

}
