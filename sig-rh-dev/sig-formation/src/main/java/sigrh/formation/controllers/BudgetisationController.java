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
import sigrh.formation.dto.BudgetisationDTO;
import sigrh.formation.servies.AgentStagiaireService;
import sigrh.formation.servies.BudgetisationService;

@RestController
@RequestMapping("/budgetisation")
@CrossOrigin("*")
public class BudgetisationController {
	
	@Autowired
	private BudgetisationService budgetService;
	
	@PostMapping("/create")
	public ResponseEntity<BudgetisationDTO> create(@RequestBody BudgetisationDTO dto) {
		BudgetisationDTO data = new BudgetisationDTO();
		if(dto!=null) {
			data = budgetService.save(dto);
		}
		return new ResponseEntity<BudgetisationDTO>(data,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<BudgetisationDTO>> getListe(){
		List<BudgetisationDTO> data = budgetService.getListe();
		return new ResponseEntity<List<BudgetisationDTO>>(data,HttpStatus.OK);
		
	}

}
