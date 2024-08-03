package sigrh.formation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="planFormation")
public class PlanFormation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlanFormation;
    private String dren;
    private String nni;
    private String objectifs;
    private String axes;
    private String cibles;
    private String modules;

}
