package sigrh.formation.controllers;

import java.util.ArrayList;
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

import sigrh.formation.dto.AgentEvaluationDTO;
import sigrh.formation.dto.CritereDTO;
import sigrh.formation.dto.SuiviEvaluationDTO;
import sigrh.formation.mappers.CritereDTOMapper;
import sigrh.formation.servies.AgentEvaluationService;
import sigrh.formation.servies.CritereService;
import sigrh.formation.servies.SuiviEvaluationService;

@RestController
@RequestMapping("/suivi-evaluation")
@CrossOrigin("*")
public class SuiviEvaluationController {
	
	@Autowired
	private SuiviEvaluationService suiviService;
	private CritereService cService;
	
	@PostMapping("/createListe")
	public ResponseEntity<List<SuiviEvaluationDTO>> createListe(@RequestBody List<SuiviEvaluationDTO> dto){
		List<SuiviEvaluationDTO> data = suiviService.saveListe(dto);
		
		return new ResponseEntity<List<SuiviEvaluationDTO>>(data, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<SuiviEvaluationDTO> create(@RequestBody SuiviEvaluationDTO dto){
		SuiviEvaluationDTO data = suiviService.save(dto);
		
		return new ResponseEntity<SuiviEvaluationDTO>(data, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<SuiviEvaluationDTO>> getAll(){
		List<SuiviEvaluationDTO> data = suiviService.getAll();
		
		return new ResponseEntity<List<SuiviEvaluationDTO>>(data, HttpStatus.OK);
	}
	
	@GetMapping("/initial")
	public ResponseEntity<List<SuiviEvaluationDTO>> ObjectInitial() {
		List<SuiviEvaluationDTO> data = suiviService.ObjectInitial();
		System.out.println("len :"+data.size());
		return new ResponseEntity<List<SuiviEvaluationDTO>>(data,HttpStatus.OK);
		
	}

}
