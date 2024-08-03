package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.BudgetisationRepository;
import sigrh.formation.dto.BudgetisationDTO;
import sigrh.formation.entities.Budgetisation;
import sigrh.formation.mappers.BudgetisationDTOMapper;


@Service
public class BudgetisationService {
	
	@Autowired
	private BudgetisationRepository budgetRepos;
	
	public BudgetisationDTO save(BudgetisationDTO dto) {
		Budgetisation budget = BudgetisationDTOMapper.MAPPER.mapToBudgetisation(dto);
		BudgetisationDTO data = BudgetisationDTOMapper.MAPPER.mapToBudgetisationDTO(budgetRepos.save(budget));
		return data;
	}
	
	public List<BudgetisationDTO> getListe(){
		List<BudgetisationDTO> dtos = new ArrayList<BudgetisationDTO>();
		List<Budgetisation> budgets = budgetRepos.findAll();
		for(Budgetisation budget : budgets) {
			dtos.add(BudgetisationDTOMapper.MAPPER.mapToBudgetisationDTO(budget));
		}
		return dtos;
				
	}

}
