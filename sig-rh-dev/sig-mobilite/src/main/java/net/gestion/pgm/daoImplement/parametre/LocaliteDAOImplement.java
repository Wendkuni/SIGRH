package net.gestion.pgm.daoImplement.parametre;


import net.gestion.pgm.dao.DAOTemplete;
import net.gestion.pgm.domains.parametres.LocaliteModel;
import net.gestion.pgm.mappers.parametre.LocaliteMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class LocaliteDAOImplement implements DAOTemplete<LocaliteModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public LocaliteDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    @Override
    public boolean create(LocaliteModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(LocaliteModel obj) {
        return false;
    }

    @Override
    public boolean update(LocaliteModel obj) {
        return false;
    }

    @Override
    public LocaliteModel find(int id) {
        return null;
    }

    @Override
    public List<LocaliteModel> findAll() {
        try {
            String SQL = "SELECT distinct * FROM localite";
            return jdbcTemplate.query(SQL,new LocaliteMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<String> ListeLocalite() {
        try {
            String SQL = "select ddren  from localite group by ddren";
            return jdbcTemplate.queryForList(SQL, String.class).stream().map(String::toUpperCase).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<String> ListeCodeW() {
        try {
            String SQL = "select codew  from localite group by codew";
            return jdbcTemplate.queryForList(SQL, String.class).stream().map(String::toUpperCase).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<String> ListeCodeMougkata() {
        try {
            String SQL = "select codemougkata  from localite group by codemougkata";
            return jdbcTemplate.queryForList(SQL, String.class).stream().map(String::toUpperCase).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<String> ListePriority() {
        try {
            String SQL = "select priority  from localite group by priority";
            return jdbcTemplate.queryForList(SQL, String.class).stream().map(String::toUpperCase).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<String> ListeNombrePoint() {
        try {
            String SQL = "select nombredepoint  from localite group by nombredepoint";
            return jdbcTemplate.queryForList(SQL, String.class).stream().map(String::toUpperCase).toList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}

