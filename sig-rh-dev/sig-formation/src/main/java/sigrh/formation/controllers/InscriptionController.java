package sigrh.formation.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sigrh.formation.dto.BudgetisationDTO;
import sigrh.formation.dto.InscriptionDTO;
import sigrh.formation.servies.BudgetisationService;
import sigrh.formation.servies.InscriptionService;

@RestController
@RequestMapping("/inscription")
@CrossOrigin("*")
public class InscriptionController {
	
	@Autowired
	private InscriptionService inscriptionService;
	
	@PostMapping("/create")
	public ResponseEntity<InscriptionDTO> create(@RequestBody InscriptionDTO dto) {
		InscriptionDTO data = new InscriptionDTO();
		if(dto!=null) {
			data = inscriptionService.save(dto);
		}
		return new ResponseEntity<InscriptionDTO>(data,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<InscriptionDTO>> getListe(){
		List<InscriptionDTO> data = inscriptionService.getListe();
		return new ResponseEntity<List<InscriptionDTO>>(data,HttpStatus.OK);
		
	}

}
