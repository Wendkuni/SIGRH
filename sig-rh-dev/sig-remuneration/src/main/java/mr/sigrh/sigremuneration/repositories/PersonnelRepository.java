package mr.sigrh.sigremuneration.repositories;

import mr.sigrh.sigremuneration.domaine.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    @Query("SELECT DISTINCT p FROM Personnel p JOIN p.absences a WHERE a.periode.id = :periode_id")
    List<Personnel> findAbsenceByPeriode(@Param("periode_id") Long periodeId);

    @Query("SELECT DISTINCT p FROM Personnel p WHERE p.id NOT IN (SELECT DISTINCT a.agent.id FROM Absence a WHERE a.periode.id = :periode_id)")
    List<Personnel> findPresenceByPeriode(@Param("periode_id") Long periodeId);
}
