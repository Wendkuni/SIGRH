package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.AgentEvaluationRepository;
import sigrh.formation.dto.AgentEvaluationDTO;
import sigrh.formation.entities.AgentEvaluation;
import sigrh.formation.mappers.AgentEvaluationDTOMapper;

@Service
public class AgentEvaluationService {

	
	@Autowired
	AgentEvaluationRepository agentRepos;
	
	public AgentEvaluationDTO save(AgentEvaluationDTO dto) {
		AgentEvaluation agent = agentRepos.save(AgentEvaluationDTOMapper.MAPPER.mapToAgentEvaluation(dto));		
		return AgentEvaluationDTOMapper.MAPPER.mapToAgentEvaluationDTO(agent);
	}
	
	public List<AgentEvaluationDTO> getAll(){
		List<AgentEvaluation> agents = agentRepos.findAll();
		List<AgentEvaluationDTO> dtos =new ArrayList<AgentEvaluationDTO>();
		
		for (AgentEvaluation agent : agents) {
			dtos.add(AgentEvaluationDTOMapper.MAPPER.mapToAgentEvaluationDTO(agent));
		}
		
		return dtos;
	}
}
