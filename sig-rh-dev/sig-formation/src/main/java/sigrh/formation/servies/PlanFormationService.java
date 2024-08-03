package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.PlanFormationRepository;
import sigrh.formation.dto.PlanFormationDTO;
import sigrh.formation.entities.PlanFormation;
import sigrh.formation.mappers.PlanFormationDTOMapper;


@Service
public class PlanFormationService {
	
	@Autowired
	private PlanFormationRepository planRepos;
	
	public PlanFormationDTO save(PlanFormationDTO dto) {
		PlanFormation budget = PlanFormationDTOMapper.MAPPER.mapToPlanFormation(dto);
		PlanFormationDTO data = PlanFormationDTOMapper.MAPPER.mapToPlanFormationDTO(planRepos.save(budget));
		return data;
	}
	
	public List<PlanFormationDTO> getListe(){
		List<PlanFormationDTO> dtos = new ArrayList<PlanFormationDTO>();
		List<PlanFormation> plans = planRepos.findAll();
		for(PlanFormation plan : plans) {
			dtos.add(PlanFormationDTOMapper.MAPPER.mapToPlanFormationDTO(plan));
		}
		return dtos;
				
	}

}
