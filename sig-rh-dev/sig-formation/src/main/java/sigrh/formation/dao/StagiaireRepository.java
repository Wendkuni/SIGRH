package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.Stagiaire;

@Repository
public interface StagiaireRepository extends JpaRepository<Stagiaire, Integer> {

}
