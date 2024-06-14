package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.LocaliteModel;

import javax.sql.DataSource;
import java.util.List;

public class LocaliteDAOImplement implements DAOTemplete<LocaliteModel> {
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
        return List.of();
    }
}
