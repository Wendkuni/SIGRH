package sigrh.formation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanFormationDTO {
	
	private Integer idPlanFormation;
    private String dren;
    private String nni;
    private String objectifs;
    private String axes;
    private String cibles;
    private String modules;

}
