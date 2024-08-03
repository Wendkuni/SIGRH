package sigrh.formation.servies;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sigrh.formation.dao.ThemeRepository;
import sigrh.formation.dto.ThemeDTO;
import sigrh.formation.entities.Theme;
import sigrh.formation.mappers.ThemeDTOMapper;

@Service
public class ThemeService {
	
	@Autowired
	private ThemeRepository themeRepos;
	
	public ThemeDTO save(ThemeDTO dto) {
		if(dto!=null) {
			Theme theme = ThemeDTOMapper.MAPPER.mapToTheme(dto);
			return ThemeDTOMapper.MAPPER.mapToThemeDTO(themeRepos.save(theme));
		}		
		return null;
	}
	
	public List<ThemeDTO> getAll(){
		List<ThemeDTO> dtos =new ArrayList<ThemeDTO>();
		List<Theme> data = themeRepos.findAll();
		for(Theme theme : data) {
			dtos.add(ThemeDTOMapper.MAPPER.mapToThemeDTO(themeRepos.save(theme)));
		}
		
		return dtos;
	}

}
