package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.Filiere;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Integer> {

	@Query(value = "select id=?1", nativeQuery = true)
	public Integer selectAll(Integer id);
}
