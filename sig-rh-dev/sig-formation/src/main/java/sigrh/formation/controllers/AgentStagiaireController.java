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

import sigrh.formation.dto.AgentStagiaireDTO;
import sigrh.formation.servies.AgentStagiaireService;


@RestController
@RequestMapping("/agent-stagiaire")
@CrossOrigin("*")
public class AgentStagiaireController {
	
	@Autowired
	private AgentStagiaireService agentService;
	
	@PostMapping("/create")
	public ResponseEntity<AgentStagiaireDTO> create(@RequestBody AgentStagiaireDTO dto) {
		AgentStagiaireDTO data = new AgentStagiaireDTO();
		if(dto!=null) {
			data = agentService.save(dto);
		}
		return new ResponseEntity<AgentStagiaireDTO>(data,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AgentStagiaireDTO>> getListe(){
		List<AgentStagiaireDTO> data = agentService.getListe();
		return new ResponseEntity<List<AgentStagiaireDTO>>(data,HttpStatus.OK);
		
	}

}
