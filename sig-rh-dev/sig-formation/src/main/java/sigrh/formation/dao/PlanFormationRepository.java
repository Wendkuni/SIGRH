package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.PlanFormation;

@Repository
public interface PlanFormationRepository extends JpaRepository<PlanFormation, Integer> {

}
