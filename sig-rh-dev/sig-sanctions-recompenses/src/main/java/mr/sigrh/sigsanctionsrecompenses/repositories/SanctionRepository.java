package mr.sigrh.sigsanctionsrecompenses.repositories;

import mr.sigrh.sigsanctionsrecompenses.domaine.Sanction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SanctionRepository extends JpaRepository<Sanction, Long> {
    List<Sanction> findByDeleted(boolean deleted);
    List<Sanction> findByType(String type);
}
