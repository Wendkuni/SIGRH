package mr.sigrh.sigremuneration.controller;

import lombok.RequiredArgsConstructor;
import mr.sigrh.sigremuneration.domaine.Periode;
import mr.sigrh.sigremuneration.services.PeriodeService;
import org.aspectj.weaver.patterns.PerObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "periodes")
public class PeriodeController {
    private static final Logger log = LoggerFactory.getLogger(PeriodeController.class);
    private final PeriodeService periodeService;

    @GetMapping
    public ResponseEntity<Periode> getActivePeriode() {
        Periode periode = periodeService.findActivePeriode(true);
        log.info("{}", periode);
        return ResponseEntity.ok(periode);
    }
}
