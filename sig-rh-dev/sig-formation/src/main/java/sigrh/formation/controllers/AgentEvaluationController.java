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

import sigrh.formation.dto.AgentEvaluationDTO;
import sigrh.formation.servies.AgentEvaluationService;

@RestController
@RequestMapping("/agent-evaluation")
@CrossOrigin("*")
public class AgentEvaluationController {
	
	@Autowired
	private AgentEvaluationService agentService;
	
	@PostMapping("/create")
	public ResponseEntity<AgentEvaluationDTO> create(@RequestBody AgentEvaluationDTO dto){
		AgentEvaluationDTO data = new AgentEvaluationDTO();
		if(dto!=null) {
			data=agentService.save(dto);
		}
		
		return new ResponseEntity<AgentEvaluationDTO>(data, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AgentEvaluationDTO>> getAll(){
		List<AgentEvaluationDTO> data = agentService.getAll();
		
		return new ResponseEntity<List<AgentEvaluationDTO>>(data, HttpStatus.OK);
	}

}
