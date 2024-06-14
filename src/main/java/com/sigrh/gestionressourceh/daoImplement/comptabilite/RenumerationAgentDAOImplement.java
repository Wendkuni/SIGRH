package com.sigrh.gestionressourceh.daoImplement.comptabilite;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.comptablite.RenumerationAgent;

import javax.sql.DataSource;
import java.util.List;

public class RenumerationAgentDAOImplement implements DAOTemplete<RenumerationAgent> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(RenumerationAgent obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(RenumerationAgent obj) {
        return false;
    }

    @Override
    public boolean update(RenumerationAgent obj) {
        return false;
    }

    @Override
    public RenumerationAgent find(int id) {
        return null;
    }

    @Override
    public List<RenumerationAgent> findAll() {
        return List.of();
    }
}
