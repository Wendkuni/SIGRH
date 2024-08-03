package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.AgentEvaluationRepository;
import sigrh.formation.dao.SuiviEvaluationRepository;
import sigrh.formation.dto.AgentEvaluationDTO;
import sigrh.formation.dto.CritereDTO;
import sigrh.formation.dto.SuiviEvaluationDTO;
import sigrh.formation.entities.AgentEvaluation;
import sigrh.formation.entities.SuiviEvaluation;
import sigrh.formation.mappers.AgentEvaluationDTOMapper;
import sigrh.formation.mappers.CritereDTOMapper;
import sigrh.formation.mappers.SuiviEvaluationDTOMapper;

@Service
public class SuiviEvaluationService {

	@Autowired
	SuiviEvaluationRepository suiviRepos;
	@Autowired
	AgentEvaluationRepository agentRepos;
	@Autowired
	private CritereService cService;
	@Autowired
	private AgentEvaluationService agentService;
	
	public List<SuiviEvaluationDTO> saveListe(List<SuiviEvaluationDTO> dtos) {
		AgentEvaluation data =agentRepos.save(dtos.get(0).getAgentEvaluation());
		List<SuiviEvaluationDTO> datas = new ArrayList<SuiviEvaluationDTO>();
		for(SuiviEvaluationDTO suivi : dtos ) {
			suivi.setAgentEvaluation(data);
			SuiviEvaluation don =suiviRepos.save(SuiviEvaluationDTOMapper.MAPPER.mapToSuiviEvaluation(suivi));
			datas.add(SuiviEvaluationDTOMapper.MAPPER.mapToSuiviEvaluationDTO(don));
		}
		
		return datas;
	}
	
	public SuiviEvaluationDTO save(SuiviEvaluationDTO dtos) {
		SuiviEvaluation data =suiviRepos.save(SuiviEvaluationDTOMapper.MAPPER.mapToSuiviEvaluation(dtos));	
		
		return SuiviEvaluationDTOMapper.MAPPER.mapToSuiviEvaluationDTO(data);
	}
	
	public List<SuiviEvaluationDTO> getAll(){
		List<SuiviEvaluation> suivis = suiviRepos.findAll();
		List<SuiviEvaluationDTO> dtos =new ArrayList<SuiviEvaluationDTO>();
		
		for (SuiviEvaluation suivi : suivis) {
			dtos.add(SuiviEvaluationDTOMapper.MAPPER.mapToSuiviEvaluationDTO(suivi));
		}
		
		return dtos;
	}
	
	public List<SuiviEvaluationDTO> ObjectInitial() {
		List<SuiviEvaluationDTO> data = new ArrayList<SuiviEvaluationDTO>();
		List<CritereDTO> dtos = cService.getAll();
		System.out.println("len :"+dtos.size());
		for(CritereDTO dto : dtos) {
			SuiviEvaluationDTO suivi = new SuiviEvaluationDTO();
			suivi.setCritere(CritereDTOMapper.MAPPER.mapToCritere(dto));
			data.add(suivi);
		}
		
		return data;
		
	}
}
