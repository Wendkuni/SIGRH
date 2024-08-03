package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.AgentStagiaireDTO;
import sigrh.formation.entities.AgentStagiaire;

@Mapper
public interface AgentStagiaireDTOMapper {
	
	AgentStagiaireDTOMapper MAPPER = Mappers.getMapper(AgentStagiaireDTOMapper.class);
	
	AgentStagiaireDTO mapToAgentStagiaireDTO(AgentStagiaire agent);
	
	AgentStagiaire mapToAgentStagiaire(AgentStagiaireDTO dto);

}
