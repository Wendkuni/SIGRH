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

import sigrh.formation.dto.PlanFormationDTO;
import sigrh.formation.servies.PlanFormationService;


@RestController
@RequestMapping("/plan-formation")
@CrossOrigin("*")
public class PlanFormationController {
	
	@Autowired
	private PlanFormationService planService;
	
	@PostMapping("/create")
	public ResponseEntity<PlanFormationDTO> create(@RequestBody PlanFormationDTO dto) {
		PlanFormationDTO data = new PlanFormationDTO();
		if(dto!=null) {
			data = planService.save(dto);
		}
		return new ResponseEntity<PlanFormationDTO>(data,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<PlanFormationDTO>> getListe(){
		List<PlanFormationDTO> data = planService.getListe();
		return new ResponseEntity<List<PlanFormationDTO>>(data,HttpStatus.OK);
		
	}

}
