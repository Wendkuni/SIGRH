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

import sigrh.formation.dto.AgentIdentificationDTO;
import sigrh.formation.servies.AgentIdentificationService;

@RestController
@RequestMapping("/agent-identification")
@CrossOrigin("*")
public class AgentIdentificationController {
	@Autowired
	private AgentIdentificationService agentService;
	
	@PostMapping("/create")
	public ResponseEntity<AgentIdentificationDTO> create(@RequestBody AgentIdentificationDTO dto) {
		AgentIdentificationDTO data = new AgentIdentificationDTO();
		if(dto!=null) {
			data = agentService.save(dto);
		}
		return new ResponseEntity<AgentIdentificationDTO>(data,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AgentIdentificationDTO>> getListe(){
		List<AgentIdentificationDTO> data = agentService.getListe();
		return new ResponseEntity<List<AgentIdentificationDTO>>(data,HttpStatus.OK);
		
	}

}
