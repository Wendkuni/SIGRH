package mr.sigrh.sigremuneration.services;

import mr.sigrh.sigremuneration.domaine.Periode;
import mr.sigrh.sigremuneration.domaine.Personnel;
import mr.sigrh.sigremuneration.dto.PersonnelDto;

import java.time.LocalDate;
import java.util.List;

public interface PersonnelService extends AbstractService<PersonnelDto> {
    List<PersonnelDto> listPresenceParPeriode(Long id);
    List<PersonnelDto> listAbsenceParPeriode(Long id);
}
