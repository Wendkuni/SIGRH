package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.InscriptionRepository;
import sigrh.formation.dto.InscriptionDTO;
import sigrh.formation.entities.Inscription;
import sigrh.formation.mappers.InscriptionDTOMapper;


@Service
public class InscriptionService {
	
	@Autowired
	private InscriptionRepository inscriptionRepos;
	
	public InscriptionDTO save(InscriptionDTO dto) {
		Inscription budget = InscriptionDTOMapper.MAPPER.mapToInscription(dto);
		InscriptionDTO data = InscriptionDTOMapper.MAPPER.mapToInscriptionDTO(inscriptionRepos.save(budget));
		return data;
	}
	
	public List<InscriptionDTO> getListe(){
		List<InscriptionDTO> dtos = new ArrayList<InscriptionDTO>();
		List<Inscription> inscrits = inscriptionRepos.findAll();
		for(Inscription inscrit : inscrits) {
			dtos.add(InscriptionDTOMapper.MAPPER.mapToInscriptionDTO(inscrit));
		}
		return dtos;
				
	}

}
