package mr.sigrh.sigremuneration.controller;

import lombok.RequiredArgsConstructor;
import mr.sigrh.sigremuneration.domaine.Personnel;
import mr.sigrh.sigremuneration.services.AbsenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody List<Personnel> personnels) {
        absenceService.saveMany(personnels);
        return ResponseEntity.ok().build();
    }
}
