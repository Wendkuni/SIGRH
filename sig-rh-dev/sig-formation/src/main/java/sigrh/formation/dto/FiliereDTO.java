package sigrh.formation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.Ecole;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiliereDTO {
	private Integer idFiliere;
    private String code;
    private String nom;
    private String sigle;
    private String typeFiliere;
    private EcoleDTO ecole;
}
