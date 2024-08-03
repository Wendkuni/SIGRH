package sigrh.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sigrh.formation.entities.Theme;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

}
