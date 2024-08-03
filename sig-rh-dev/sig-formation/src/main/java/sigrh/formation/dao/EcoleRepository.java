package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.Ecole;

@Repository
public interface EcoleRepository extends JpaRepository<Ecole, Integer> {

}
