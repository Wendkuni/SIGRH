package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.StagiaireRepository;
import sigrh.formation.dto.StagiaireDTO;
import sigrh.formation.entities.Stagiaire;
import sigrh.formation.mappers.StagiaireDTOMapper;


@Service
public class StagiaireService {
	
	@Autowired
	private  StagiaireRepository stageRepos;
	
	public  StagiaireDTO save( StagiaireDTO dto) {
		 Stagiaire stage =  StagiaireDTOMapper.MAPPER.mapToStagiaire(dto);
		 StagiaireDTO data =  StagiaireDTOMapper.MAPPER.mapToStagiaireDTO(stageRepos.save(stage));
		return data;
	}
	
	public List<StagiaireDTO> getListe(){
		List<StagiaireDTO> dtos = new ArrayList<StagiaireDTO>();
		List<Stagiaire> stages = stageRepos.findAll();
		for(Stagiaire stage : stages) {
			dtos.add(StagiaireDTOMapper.MAPPER.mapToStagiaireDTO(stage));
		}
		return dtos;
				
	}

}
