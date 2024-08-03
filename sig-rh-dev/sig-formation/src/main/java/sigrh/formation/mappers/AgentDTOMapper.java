package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.AgentDTO;
import sigrh.formation.entities.Agent;

@Mapper
public interface AgentDTOMapper {
	AgentDTOMapper MAPPER = Mappers.getMapper(AgentDTOMapper.class);
	
	Agent mapToAgent(AgentDTO dto);
	AgentDTO mapToAgentDTO(Agent agent);
	
	

}
