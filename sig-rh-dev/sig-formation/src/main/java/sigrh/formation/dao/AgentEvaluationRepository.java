package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.AgentEvaluation;

@Repository
public interface AgentEvaluationRepository extends JpaRepository<AgentEvaluation, Integer> {

}
