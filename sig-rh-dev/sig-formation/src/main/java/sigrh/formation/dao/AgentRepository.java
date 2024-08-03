package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
