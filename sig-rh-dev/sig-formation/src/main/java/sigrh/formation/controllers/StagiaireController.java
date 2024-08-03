package sigrh.formation.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sigrh.formation.dto.StagiaireDTO;
import sigrh.formation.servies.StagiaireService;


@RestController
@RequestMapping("/stagiaire")
@CrossOrigin("*")
public class StagiaireController {
	
	@Autowired
	private StagiaireService stageService;
	
	@PutMapping(value="/create", produces="application/json")
	public ResponseEntity<StagiaireDTO> create(@RequestBody StagiaireDTO dto) {

		System.out.println(" Stage : "+dto.getNom());
		StagiaireDTO data = new StagiaireDTO();
		if(dto!=null) {
			data = stageService.save(dto);
		}
		return new ResponseEntity<StagiaireDTO>(data,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<StagiaireDTO>> getListe(){
		List<StagiaireDTO> data = stageService.getListe();
		return new ResponseEntity<List<StagiaireDTO>>(data,HttpStatus.OK);
		
	}

}
