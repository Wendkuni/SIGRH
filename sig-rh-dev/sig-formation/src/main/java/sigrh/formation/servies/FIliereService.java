package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.FiliereRepository;
import sigrh.formation.dto.FiliereDTO;
import sigrh.formation.entities.Filiere;
import sigrh.formation.mappers.FiliereDTOMapper;

@Service
public class FIliereService {
	@Autowired
	private FiliereRepository filiereRepo;
	private FiliereDTOMapper mapper;
	
	public FiliereDTO save(FiliereDTO dto) {
		FiliereDTO datadto = new FiliereDTO();
		Filiere data = new Filiere();
		if(dto!=null) {
			data = filiereRepo.save( FiliereDTOMapper.MAPPER.mapToFiliere(dto));
			datadto = FiliereDTOMapper.MAPPER.mapToFiliereDTOMapper(data);					
		}
		
		return datadto;
	}
	
	public List<FiliereDTO> getAll(){
		List<Filiere> data = filiereRepo.findAll();
		List<FiliereDTO> dtos = new ArrayList<FiliereDTO>();
		for (Filiere fil : data) {
			//FiliereDTO dto = new FiliereDTO();
			dtos.add(FiliereDTOMapper.MAPPER.mapToFiliereDTOMapper(fil));
		}
		
		return dtos;
	}

}
