package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import sigrh.formation.dao.AgentStagiaireRepository;
import sigrh.formation.dto.AgentStagiaireDTO;
import sigrh.formation.entities.AgentStagiaire;
import sigrh.formation.mappers.AgentStagiaireDTOMapper;


@Service
public class AgentStagiaireService {
	@Autowired
	private AgentStagiaireRepository agentRepos;
	
	public AgentStagiaireDTO save(@RequestBody AgentStagiaireDTO dto) {
		AgentStagiaire agent = AgentStagiaireDTOMapper.MAPPER.mapToAgentStagiaire(dto);
		AgentStagiaireDTO data = AgentStagiaireDTOMapper.MAPPER.mapToAgentStagiaireDTO(agentRepos.save(agent));
		return data;
	}
	
	public List<AgentStagiaireDTO> getListe(){
		List<AgentStagiaireDTO> dtos = new ArrayList<AgentStagiaireDTO>();
		List<AgentStagiaire> agents = agentRepos.findAll();
		for(AgentStagiaire agent : agents) {
			dtos.add(AgentStagiaireDTOMapper.MAPPER.mapToAgentStagiaireDTO(agent));
		}
		return dtos;
				
	}


}
