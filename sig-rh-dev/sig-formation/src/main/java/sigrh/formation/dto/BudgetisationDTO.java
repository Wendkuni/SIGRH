package sigrh.formation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BudgetisationDTO {
	
	private Integer idBudgetisation;
	private String structure;
    private String axe;
    private String action;
    private String activites;
    private Integer quantiteAn1;
    private Integer quantiteAn2;
    private Integer quantiteAn3;
    private Integer quantiteAn4;
    private Integer quantiteAn5;
    private Integer coutUnitaire;
    private Integer coutAn1;
    private Integer coutAn2;
    private Integer coutAn3;
    private Integer coutAn4;
    private Integer coutAn5;
    private Integer coutTotalAn1;
    private Integer coutTotalAn2;
    private Integer coutTotalAn3;
    private Integer coutTotalAn4;
    private Integer coutTotalAn5;

}
