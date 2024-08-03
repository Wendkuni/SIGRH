package sigrh.formation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import sigrh.formation.dto.ThemeDTO;
import sigrh.formation.entities.Theme;

@Mapper
public interface ThemeDTOMapper {
	
	ThemeDTOMapper MAPPER = Mappers.getMapper(ThemeDTOMapper.class);
	
	
	Theme mapToTheme(ThemeDTO dto);
	ThemeDTO mapToThemeDTO(Theme theme);
}
