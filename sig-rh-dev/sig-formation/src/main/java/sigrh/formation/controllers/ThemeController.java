package sigrh.formation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sigrh.formation.dto.ThemeDTO;
import sigrh.formation.servies.ThemeService;

@RestController
@RequestMapping("/theme")
@CrossOrigin("*")
public class ThemeController {
	
	@Autowired
	private ThemeService themeService;
	
	@PostMapping("/create")
	public ResponseEntity<ThemeDTO> create(@RequestBody ThemeDTO dto){
		ThemeDTO data = new ThemeDTO();
		if(dto!=null) {
			data=themeService.save(dto);			
		}
		return new ResponseEntity<ThemeDTO>(data, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<ThemeDTO>> getListe(){
		List<ThemeDTO> data = themeService.getAll();		
		return new ResponseEntity<List<ThemeDTO>>(data, HttpStatus.OK);
	}

}
