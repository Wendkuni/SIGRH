package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.SuiviEvaluation;

@Repository
public interface SuiviEvaluationRepository extends JpaRepository<SuiviEvaluation, Integer> {

}
