package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.LocaliteModel;
import com.sigrh.gestionressourceh.mappers.parametre.FonctionListeMapper;
import com.sigrh.gestionressourceh.mappers.parametre.LocaliteMapper;
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
    public void setDataSource(DataSource ds) {

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
}