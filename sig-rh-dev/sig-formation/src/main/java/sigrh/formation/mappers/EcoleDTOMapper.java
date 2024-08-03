package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.EcoleDTO;
import sigrh.formation.entities.Ecole;

@Mapper
public interface EcoleDTOMapper {
	
	EcoleDTOMapper MAPPER = Mappers.getMapper(EcoleDTOMapper.class);
	
	EcoleDTO mapToEcoleDTOMapper(Ecole ecole);
	Ecole mapToEcole(EcoleDTO dto);

}
