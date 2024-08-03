package mr.sigrh.sigsanctionsrecompenses.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.GeneratedValue;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.sigrh.sigsanctionsrecompenses.dto.PersonnelDto;
import mr.sigrh.sigsanctionsrecompenses.dto.SanctionDto;
import mr.sigrh.sigsanctionsrecompenses.service.PersonnelService;
import mr.sigrh.sigsanctionsrecompenses.service.SanctionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Sanction")
@RequestMapping(value = "sanctions")
@Slf4j
public class SanctionController {

    private final SanctionService sanctionService;
    @PostMapping
    public ResponseEntity<Long> save(@RequestBody @Valid SanctionDto dto) {
        log.info("Received request to save sanction: {}", dto);
        Long result = sanctionService.save(dto);
        log.info("Sanction saved with ID: {}", result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("{id}")
    public ResponseEntity<SanctionDto> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(sanctionService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<SanctionDto>> findAll() {
        return ResponseEntity.ok(sanctionService.findByDeleted(false));
    }

    @GetMapping("bytype/{type}")
    public ResponseEntity<List<SanctionDto>> findByType(@PathVariable String type) {
        return ResponseEntity.ok(sanctionService.findByType(type));
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long id) {
        SanctionDto sanction = sanctionService.findById(id);
        sanctionService.deleteById(sanction);
    }
}
