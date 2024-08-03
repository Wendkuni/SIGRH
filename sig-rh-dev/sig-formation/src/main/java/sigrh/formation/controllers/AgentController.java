package sigrh.formation.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import sigrh.formation.dto.AgentDTO;
import sigrh.formation.servies.AgentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent")
@CrossOrigin("*")
public class AgentController {
	
	@Autowired
	private AgentService agentService;
	
	@PostMapping(value="/create", produces="application/json")
	public ResponseEntity<AgentDTO> create(@RequestBody AgentDTO dto) {
		AgentDTO data = new AgentDTO();
		if(dto!=null) {
			data = agentService.save(dto);
		}
		return new ResponseEntity<AgentDTO>(data, HttpStatus.OK);
	}
	

	@GetMapping("/all")
	public ResponseEntity<List<AgentDTO>> getListe(){
		List<AgentDTO> data =agentService.getAll();		
		return new ResponseEntity<List<AgentDTO>>(data,HttpStatus.OK);
	}
}
