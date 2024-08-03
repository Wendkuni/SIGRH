package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.AgentIdentification;

@Repository
public interface AgentIdentificationRepository extends JpaRepository<AgentIdentification, Integer> {

}
