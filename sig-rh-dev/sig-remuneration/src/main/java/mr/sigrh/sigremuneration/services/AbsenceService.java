package mr.sigrh.sigremuneration.services;

import mr.sigrh.sigremuneration.domaine.Absence;
import mr.sigrh.sigremuneration.domaine.Personnel;

import java.util.List;

public interface AbsenceService extends AbstractService<Absence> {
    void saveMany(List<Personnel> personnels);
}
