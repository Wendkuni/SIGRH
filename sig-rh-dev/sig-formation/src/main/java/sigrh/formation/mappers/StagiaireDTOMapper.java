package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.StagiaireDTO;
import sigrh.formation.entities.Stagiaire;

@Mapper
public interface StagiaireDTOMapper {
	
	StagiaireDTOMapper MAPPER = Mappers.getMapper(StagiaireDTOMapper.class);
	
	StagiaireDTO mapToStagiaireDTO(Stagiaire satge);
	Stagiaire mapToStagiaire(StagiaireDTO dto);

}
