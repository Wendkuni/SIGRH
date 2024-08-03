package mr.sigrh.sigremuneration.services.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import mr.sigrh.sigremuneration.domaine.Periode;
import mr.sigrh.sigremuneration.domaine.Personnel;
import mr.sigrh.sigremuneration.dto.PersonnelDto;
import mr.sigrh.sigremuneration.repositories.PeriodeRepository;
import mr.sigrh.sigremuneration.repositories.PersonnelRepository;
import mr.sigrh.sigremuneration.services.PersonnelService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonnelServiceImpl implements PersonnelService {

    private final PersonnelRepository personnelRepository;

    private final PeriodeRepository periodeRepository;
    @Override
    public Long save(PersonnelDto dto) {
        return 0L;
    }

    @Override
    public List<PersonnelDto> findAll() {
        return personnelRepository.findAll().stream().map(PersonnelDto::fromPersonnel).toList();
    }

    @Override
    public PersonnelDto findById(Long id) {
        return personnelRepository.findById(id).map(PersonnelDto::fromPersonnel).orElse(null);
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<PersonnelDto> listPresenceParPeriode(Long id) {
        return personnelRepository.findPresenceByPeriode(periodeRepository.findById(id).get().getId()).stream().map(PersonnelDto::fromPersonnel).toList();
    }

    @Override
    public List<PersonnelDto> listAbsenceParPeriode(Long id) {
        return personnelRepository.findAbsenceByPeriode(periodeRepository.findById(id).get().getId()).stream().map(PersonnelDto::fromPersonnel).toList();
    }
}
