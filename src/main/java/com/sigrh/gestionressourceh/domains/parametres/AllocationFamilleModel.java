package com.sigrh.gestionressourceh.domains.parametres;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllocationFamilleModel implements Serializable {
    private Long idAllocation;
    private PersonnelModel personnel;
    private String etatact;
    private String corpsA;
    private String echelon;
    private String echelle;
    private String indexe;
    private String nomPrenomPrise;
    private LocalDate dateEffet;
    private LocalDate dateNaissancePrise;
    private String refDecret;

}
