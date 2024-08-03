package mr.sigrh.sigsanctionsrecompenses.repositories;

import mr.sigrh.sigsanctionsrecompenses.domaine.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    List<Personnel> findByTypef(String typeF);
}
