package com.sigrh.gestionressourceh.domains.parametres;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourriertbModel implements Serializable {
    private  long idCourtierTb;
    private String libecourriel;
    private String typDeCourrier;
    private String sourceCourrier;
    private String inoutInterne;
    private String inoutExterne;
    private Boolean validAtioncr;
    private String observation;
    private String acter1;
    private String acter2;
    private String acter3;
    private String destinatinCourier;
    private Boolean ventilation;
    private LocalDate dateVentilation;
    private String observtncr;
    private  String ndoc;
    private  String annotationDoc;
    private  String siSG;
    private LocalDate dteop;
}
