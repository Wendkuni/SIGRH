package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.FonctionAgentModel;

import javax.sql.DataSource;
import java.util.List;

public class FonctionAgentDAOImplement implements DAOTemplete<FonctionAgentModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(FonctionAgentModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(FonctionAgentModel obj) {
        return false;
    }

    @Override
    public boolean update(FonctionAgentModel obj) {
        return false;
    }

    @Override
    public FonctionAgentModel find(int id) {
        return null;
    }

    @Override
    public List<FonctionAgentModel> findAll() {
        return List.of();
    }
}
