package sigrh.formation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CritereDTO {
	
	private Integer idCritere;
    private String texte;
    private String isValide;

}
