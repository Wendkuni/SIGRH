package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.AgentEvaluationDTO;
import sigrh.formation.entities.AgentEvaluation;

@Mapper
public interface AgentEvaluationDTOMapper {

	AgentEvaluationDTOMapper MAPPER = Mappers.getMapper(AgentEvaluationDTOMapper.class);
	
	AgentEvaluationDTO mapToAgentEvaluationDTO (AgentEvaluation agent);
	AgentEvaluation mapToAgentEvaluation(AgentEvaluationDTO dto);
}
