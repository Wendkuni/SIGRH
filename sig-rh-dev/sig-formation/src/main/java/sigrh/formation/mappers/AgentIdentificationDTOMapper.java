package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.AgentIdentificationDTO;
import sigrh.formation.entities.AgentIdentification;

@Mapper
public interface AgentIdentificationDTOMapper {

	AgentIdentificationDTOMapper MAPPER = Mappers.getMapper(AgentIdentificationDTOMapper.class);
	
	AgentIdentificationDTO mapToAgentIdentificationDTO(AgentIdentification agent);
	AgentIdentification mapToAgentIdentification(AgentIdentificationDTO dto);
}
