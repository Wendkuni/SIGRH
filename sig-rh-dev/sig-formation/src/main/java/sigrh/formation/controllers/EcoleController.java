package sigrh.formation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sigrh.formation.dto.EcoleDTO;
import sigrh.formation.servies.EcoleService;

@RestController
@RequestMapping("/ecole")
@CrossOrigin("*")
public class EcoleController {
	
	@Autowired
	private EcoleService ecoleService;
	
	@PostMapping("/create")
	public ResponseEntity<EcoleDTO> save(@RequestBody EcoleDTO dto){
		EcoleDTO data = ecoleService.save(dto);
		
		return new ResponseEntity<EcoleDTO>(data,HttpStatus.OK);
	}

}
