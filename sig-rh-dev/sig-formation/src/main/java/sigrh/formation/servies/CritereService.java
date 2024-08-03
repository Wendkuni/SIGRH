package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.CritereRepository;
import sigrh.formation.dto.CritereDTO;
import sigrh.formation.entities.Critere;
import sigrh.formation.mappers.CritereDTOMapper;


@Service
public class CritereService {
	
	@Autowired
	private CritereRepository critereRepos;
	
	public CritereDTO save(CritereDTO dto) {
		Critere critere = CritereDTOMapper.MAPPER.mapToCritere(dto);
		
		return CritereDTOMapper.MAPPER.mapToCritereDTO(critereRepos.save(critere));
	}
	
	public List<CritereDTO> getAll(){
		List<Critere> data = critereRepos.findAll();
		List<CritereDTO> dtos =  new ArrayList<CritereDTO>();
		for (Critere crit : data) {
			dtos.add(CritereDTOMapper.MAPPER.mapToCritereDTO(crit));
		}
		
		return dtos;
	}

}
