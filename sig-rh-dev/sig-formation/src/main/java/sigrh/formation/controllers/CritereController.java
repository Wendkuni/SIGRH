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

import sigrh.formation.dto.CritereDTO;
import sigrh.formation.servies.CritereService;

@RestController
@RequestMapping("/critere")
@CrossOrigin("*")
public class CritereController {
	
	@Autowired
	private CritereService critereService;
	
	@PostMapping("/create")
	public ResponseEntity<CritereDTO> create(@RequestBody CritereDTO dto) {
		CritereDTO data = new CritereDTO();
		System.out.println("Critere :"+dto.getTexte());
		if(dto!=null) {
			data= critereService.save(dto);
		}
		
		return new ResponseEntity<CritereDTO>(data, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CritereDTO>> getAll(){
		List<CritereDTO> data = critereService.getAll();
		return new ResponseEntity<List<CritereDTO>>(data, HttpStatus.OK);
	}

}
