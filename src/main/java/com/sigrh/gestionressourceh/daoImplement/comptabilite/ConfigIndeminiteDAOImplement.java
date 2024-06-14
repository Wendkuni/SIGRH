package com.sigrh.gestionressourceh.daoImplement.comptabilite;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.comptablite.ConfigIdemit;

import javax.sql.DataSource;
import java.util.List;

public class ConfigIndeminiteDAOImplement implements DAOTemplete<ConfigIdemit> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(ConfigIdemit obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(ConfigIdemit obj) {
        return false;
    }

    @Override
    public boolean update(ConfigIdemit obj) {
        return false;
    }

    @Override
    public ConfigIdemit find(int id) {
        return null;
    }

    @Override
    public List<ConfigIdemit> findAll() {
        return List.of();
    }
}
