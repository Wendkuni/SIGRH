package com.sigrh.gestionressourceh.daoImplement.personnel;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;

import javax.sql.DataSource;
import java.util.List;

public class AffectationDAOImplement implements DAOTemplete<PersonnelAffectationModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(PersonnelAffectationModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(PersonnelAffectationModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelAffectationModel obj) {
        return false;
    }

    @Override
    public PersonnelAffectationModel find(int id) {
        return null;
    }

    @Override
    public List<PersonnelAffectationModel> findAll() {
        return List.of();
    }
}
