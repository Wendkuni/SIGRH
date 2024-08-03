package mr.sigrh.sigsanctionsrecompenses.repositories;

import mr.sigrh.sigsanctionsrecompenses.domaine.AgentSanction;
import mr.sigrh.sigsanctionsrecompenses.domaine.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentSanctionRepository extends JpaRepository<AgentSanction, Long> {
}
