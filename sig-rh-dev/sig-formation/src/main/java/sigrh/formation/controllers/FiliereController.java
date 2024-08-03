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

import sigrh.formation.dao.FiliereRepository;
import sigrh.formation.dto.FiliereDTO;
import sigrh.formation.servies.FIliereService;


@RestController
@RequestMapping("/filiere")
@CrossOrigin("*")
public class FiliereController {
	
	@Autowired
	private FIliereService filiereService;
	
	@PostMapping("/create")
	ResponseEntity<FiliereDTO> save(@RequestBody FiliereDTO dto) {
		FiliereDTO result = filiereService.save(dto);
	
		return new ResponseEntity<FiliereDTO>(result,HttpStatus.OK);
	}
	
	
	@GetMapping("/all")
	ResponseEntity<List<FiliereDTO>> getListe(){
		List<FiliereDTO> dtos = filiereService.getAll();
		
		return new ResponseEntity<List<FiliereDTO>>(dtos,HttpStatus.OK);
	}

}
