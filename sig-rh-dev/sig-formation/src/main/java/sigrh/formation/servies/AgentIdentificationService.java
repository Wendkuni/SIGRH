package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import sigrh.formation.dao.AgentIdentificationRepository;
import sigrh.formation.dto.AgentIdentificationDTO;
import sigrh.formation.entities.AgentIdentification;
import sigrh.formation.mappers.AgentIdentificationDTOMapper;

@Service
public class AgentIdentificationService {
	
	@Autowired
	private AgentIdentificationRepository agentRepos;
	
	public AgentIdentificationDTO save(@RequestBody AgentIdentificationDTO dto) {
		AgentIdentification agent = AgentIdentificationDTOMapper.MAPPER.mapToAgentIdentification(dto);
		AgentIdentificationDTO data = AgentIdentificationDTOMapper.MAPPER.mapToAgentIdentificationDTO(agentRepos.save(agent));
		return data;
	}
	
	public List<AgentIdentificationDTO> getListe(){
		List<AgentIdentificationDTO> dtos = new ArrayList<AgentIdentificationDTO>();
		List<AgentIdentification> agents = agentRepos.findAll();
		for(AgentIdentification agent : agents) {
			dtos.add(AgentIdentificationDTOMapper.MAPPER.mapToAgentIdentificationDTO(agent));
		}
		return dtos;
				
	}

}
