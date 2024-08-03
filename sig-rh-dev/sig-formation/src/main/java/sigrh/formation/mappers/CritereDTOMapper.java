package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.CritereDTO;
import sigrh.formation.entities.Critere;

@Mapper
public interface CritereDTOMapper {
	
	CritereDTOMapper MAPPER = Mappers.getMapper(CritereDTOMapper.class);
	
	CritereDTO mapToCritereDTO(Critere critere);
	Critere mapToCritere(CritereDTO dto);

}
