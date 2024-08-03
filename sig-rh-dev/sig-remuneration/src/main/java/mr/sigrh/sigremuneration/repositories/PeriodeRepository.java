package mr.sigrh.sigremuneration.repositories;

import mr.sigrh.sigremuneration.domaine.Periode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode, Long> {
    Periode findByActif(boolean actif);
}
