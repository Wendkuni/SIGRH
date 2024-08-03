package mr.sigrh.sigremuneration.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import mr.sigrh.sigremuneration.domaine.Absence;
import mr.sigrh.sigremuneration.domaine.Periode;
import mr.sigrh.sigremuneration.domaine.Personnel;
import mr.sigrh.sigremuneration.repositories.AbsenceRepository;
import mr.sigrh.sigremuneration.repositories.PeriodeRepository;
import mr.sigrh.sigremuneration.repositories.PersonnelRepository;
import mr.sigrh.sigremuneration.services.AbsenceService;
import mr.sigrh.sigremuneration.services.PeriodeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;

    private final PeriodeService periodeService;

    private final PersonnelRepository personnelRepository;
    @Override
    public Long save(Absence dto) {
        return absenceRepository.save(dto).getId();
    }

    @Override
    public void saveMany(List<Personnel> personnels) {
        for (Personnel personnel : personnels) {
            Periode periode = periodeService.findActivePeriode(true);
            Absence absence = new Absence();
            absence.setPeriode(periode);
            absence.setAgent(personnel);
            absenceRepository.save(absence);
        }
    }

    @Override
    public List<Absence> findAll() {
        return absenceRepository.findAll();
    }

    @Override
    public Absence findById(Long id) {
        return absenceRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        absenceRepository.deleteById(id);
    }

}
