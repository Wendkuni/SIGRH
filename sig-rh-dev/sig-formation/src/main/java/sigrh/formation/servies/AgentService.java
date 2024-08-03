package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.AgentRepository;
import sigrh.formation.dto.AgentDTO;
import sigrh.formation.entities.Agent;
import sigrh.formation.mappers.AgentDTOMapper;

@Service
public class AgentService {
	
	@Autowired
	private AgentRepository agentRepos;
	
	public AgentDTO save(AgentDTO dto) {
		Agent agent = AgentDTOMapper.MAPPER.mapToAgent(dto);
		Agent data = agentRepos.save(agent);
		if(data!=null) {
			return AgentDTOMapper.MAPPER.mapToAgentDTO(data); 
		}
		return null;
	}
	
	public List<AgentDTO> getAll(){
		List<AgentDTO> dtos = new ArrayList<AgentDTO>();
		List<Agent> agents = agentRepos.findAll();
		if(agents.size()!=0) {
			for(Agent agent: agents) {
				AgentDTO dto = new AgentDTO();
				dto=AgentDTOMapper.MAPPER.mapToAgentDTO(agent);
				dtos.add(dto);
			}
		}
		
		return dtos;
	}

}
