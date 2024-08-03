package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.FiliereDTO;
import sigrh.formation.entities.Filiere;

@Mapper
public interface FiliereDTOMapper {
	
	FiliereDTOMapper MAPPER= Mappers.getMapper(FiliereDTOMapper.class);
	
	FiliereDTO mapToFiliereDTOMapper(Filiere filiere);
	Filiere mapToFiliere(FiliereDTO filieredto);

}
