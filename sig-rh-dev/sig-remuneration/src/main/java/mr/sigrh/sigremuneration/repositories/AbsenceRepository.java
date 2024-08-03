package mr.sigrh.sigremuneration.repositories;

import mr.sigrh.sigremuneration.domaine.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
}
