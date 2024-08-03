package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.Budgetisation;

@Repository
public interface BudgetisationRepository extends JpaRepository<Budgetisation, Integer> {

}
