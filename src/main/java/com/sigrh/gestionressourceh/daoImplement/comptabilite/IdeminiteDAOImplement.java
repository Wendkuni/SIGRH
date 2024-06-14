package com.sigrh.gestionressourceh.daoImplement.comptabilite;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.comptablite.IndeminiteModel;

import javax.sql.DataSource;
import java.util.List;

public class IdeminiteDAOImplement implements DAOTemplete<IndeminiteModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(IndeminiteModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(IndeminiteModel obj) {
        return false;
    }

    @Override
    public boolean update(IndeminiteModel obj) {
        return false;
    }

    @Override
    public IndeminiteModel find(int id) {
        return null;
    }

    @Override
    public List<IndeminiteModel> findAll() {
        return List.of();
    }
}
