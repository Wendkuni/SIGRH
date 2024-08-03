package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.BudgetisationDTO;
import sigrh.formation.entities.Budgetisation;

@Mapper
public interface BudgetisationDTOMapper {
	
	BudgetisationDTOMapper MAPPER = Mappers.getMapper(BudgetisationDTOMapper.class);
	
	BudgetisationDTO mapToBudgetisationDTO(Budgetisation budget);
	Budgetisation mapToBudgetisation(BudgetisationDTO dto);

}
