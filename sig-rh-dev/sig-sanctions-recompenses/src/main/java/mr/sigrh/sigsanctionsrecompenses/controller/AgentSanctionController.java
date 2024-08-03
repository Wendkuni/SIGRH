package mr.sigrh.sigsanctionsrecompenses.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.sigrh.sigsanctionsrecompenses.dto.AgentSanctionDto;
import mr.sigrh.sigsanctionsrecompenses.dto.PersonnelDto;
import mr.sigrh.sigsanctionsrecompenses.service.AgentSanctionService;
import mr.sigrh.sigsanctionsrecompenses.service.PersonnelService;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Agent-sanction")
@Slf4j
@RequestMapping(value = "/agent-sanctions")  // Correction added for clarity in the URL mapping
public class AgentSanctionController {

    private final AgentSanctionService agentSanctionService;
    private final PersonnelService personnelService;


    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Long> save(@ModelAttribute AgentSanctionDto dto) {
        try {
            System.out.println("Received request to save agent-sanction: " + dto);
            Long result = agentSanctionService.save(dto);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println("Error saving agent-sanction: " + e.getMessage());
            return ResponseEntity.badRequest().build(); // Provide more specific error info if needed
        }
    }

    @PostMapping(value = "/demandeExplication", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Long> save(List<MultipartFile> files) {
        files.forEach(file -> {
            System.out.println(file.getOriginalFilename());
        });
        return ResponseEntity.ok(1L);
    }

    @GetMapping("personnels/prestataires")
    public ResponseEntity<List<PersonnelDto>> findPrestataires() {
        return ResponseEntity.ok(personnelService.findByTypeF("prestataire"));
    }

    @GetMapping("personnels/contractuels")
    public ResponseEntity<List<PersonnelDto>> findContractuels() {
        return ResponseEntity.ok(personnelService.findByTypeF("contractuel"));
    }

    @GetMapping("personnels/fonctionnaires")
    public ResponseEntity<List<PersonnelDto>> findFonctionnaire() {
        return ResponseEntity.ok(personnelService.findByTypeF("fonctionnaire"));
    }


    @GetMapping
    public ResponseEntity<List<AgentSanctionDto>> findAll() {
        return ResponseEntity.ok(agentSanctionService.findAll());
    }
}
