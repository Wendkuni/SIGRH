package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.EcolesModel;

import javax.sql.DataSource;
import java.util.List;

public class EcoleDAOImplement implements DAOTemplete<EcolesModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(EcolesModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(EcolesModel obj) {
        return false;
    }

    @Override
    public boolean update(EcolesModel obj) {
        return false;
    }

    @Override
    public EcolesModel find(int id) {
        return null;
    }

    @Override
    public List<EcolesModel> findAll() {
        return List.of();
    }
}
