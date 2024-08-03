package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.PlanFormationDTO;
import sigrh.formation.entities.PlanFormation;

@Mapper
public interface PlanFormationDTOMapper {
	
	PlanFormationDTOMapper MAPPER = Mappers.getMapper(PlanFormationDTOMapper.class);
	
	PlanFormationDTO mapToPlanFormationDTO(PlanFormation plan);
	PlanFormation mapToPlanFormation(PlanFormationDTO dto);

}
