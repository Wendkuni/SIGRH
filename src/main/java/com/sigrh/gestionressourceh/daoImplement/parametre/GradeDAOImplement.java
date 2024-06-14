package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.GradeModel;

import javax.sql.DataSource;
import java.util.List;

public class GradeDAOImplement implements DAOTemplete<GradeModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(GradeModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(GradeModel obj) {
        return false;
    }

    @Override
    public boolean update(GradeModel obj) {
        return false;
    }

    @Override
    public GradeModel find(int id) {
        return null;
    }

    @Override
    public List<GradeModel> findAll() {
        return List.of();
    }
}
