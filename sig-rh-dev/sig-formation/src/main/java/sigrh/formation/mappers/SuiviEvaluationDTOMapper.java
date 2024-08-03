package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.SuiviEvaluationDTO;
import sigrh.formation.entities.SuiviEvaluation;

@Mapper
public interface SuiviEvaluationDTOMapper {
	
	SuiviEvaluationDTOMapper MAPPER = Mappers.getMapper(SuiviEvaluationDTOMapper.class);
	
	SuiviEvaluationDTO mapToSuiviEvaluationDTO(SuiviEvaluation suivi);
	
	SuiviEvaluation mapToSuiviEvaluation(SuiviEvaluationDTO dto);

}
