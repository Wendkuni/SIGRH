package com.sigrh.gestionressourceh.daoImplement.comptabilite;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.comptablite.IndeminitesListeModel;

import javax.sql.DataSource;
import java.util.List;

public class IdeminiteListeDAOImplement implements DAOTemplete<IndeminitesListeModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(IndeminitesListeModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(IndeminitesListeModel obj) {
        return false;
    }

    @Override
    public boolean update(IndeminitesListeModel obj) {
        return false;
    }

    @Override
    public IndeminitesListeModel find(int id) {
        return null;
    }

    @Override
    public List<IndeminitesListeModel> findAll() {
        return List.of();
    }
}
