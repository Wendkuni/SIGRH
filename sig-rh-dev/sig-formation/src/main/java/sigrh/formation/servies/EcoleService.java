package sigrh.formation.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.EcoleRepository;
import sigrh.formation.dto.EcoleDTO;
import sigrh.formation.entities.Ecole;
import sigrh.formation.mappers.EcoleDTOMapper;

@Service
public class EcoleService {
	
	@Autowired
	private EcoleRepository ecoleRepos;
	
	private EcoleDTOMapper mapper;
	
	public EcoleDTO save(EcoleDTO dto) {
		EcoleDTO data = new EcoleDTO();
		Ecole dt = mapper.MAPPER.mapToEcole(dto);
		data=mapper.MAPPER.mapToEcoleDTOMapper(ecoleRepos.save(dt));
		return data;
	}

}
