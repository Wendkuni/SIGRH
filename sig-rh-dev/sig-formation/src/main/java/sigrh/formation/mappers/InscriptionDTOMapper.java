package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.InscriptionDTO;
import sigrh.formation.entities.Inscription;

@Mapper
public interface InscriptionDTOMapper {
	
	InscriptionDTOMapper MAPPER = Mappers.getMapper(InscriptionDTOMapper.class);
	
	InscriptionDTO mapToInscriptionDTO(Inscription inscription);
	Inscription mapToInscription(InscriptionDTO dto);

}
