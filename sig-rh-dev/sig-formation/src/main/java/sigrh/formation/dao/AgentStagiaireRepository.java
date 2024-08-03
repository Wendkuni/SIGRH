package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.AgentStagiaire;

@Repository
public interface AgentStagiaireRepository extends JpaRepository<AgentStagiaire, Integer> {

}
