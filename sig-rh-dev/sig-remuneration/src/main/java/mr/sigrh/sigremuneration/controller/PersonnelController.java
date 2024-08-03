package mr.sigrh.sigremuneration.controller;

import lombok.RequiredArgsConstructor;
import mr.sigrh.sigremuneration.domaine.Periode;
import mr.sigrh.sigremuneration.domaine.Personnel;
import mr.sigrh.sigremuneration.dto.PersonnelDto;
import mr.sigrh.sigremuneration.services.serviceImpl.PersonnelServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "personnels")
public class PersonnelController {

    private final PersonnelServiceImpl personnelService;

    @GetMapping
    public ResponseEntity<List<PersonnelDto>> getAllPersonnels() {
        return ResponseEntity.ok( personnelService.findAll());
    }

    @GetMapping("presence/{periode}")
    public ResponseEntity<List<PersonnelDto>> getPresenceByPeriode(@PathVariable("periode") Long id) {
        return ResponseEntity.ok(personnelService.listPresenceParPeriode(id));
    }

    @GetMapping("absence/{periode}")
    public ResponseEntity<List<PersonnelDto>> getAbsenceByPeriode(@PathVariable("periode") Long id) {
        return ResponseEntity.ok( personnelService.listAbsenceParPeriode(id));
    }
}
