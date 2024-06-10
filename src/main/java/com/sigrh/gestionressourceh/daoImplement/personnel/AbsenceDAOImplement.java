package com.sigrh.gestionressourceh.daoImplement.personnel;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAbsenceModel;

import javax.sql.DataSource;
import java.util.List;

public class AbsenceDAOImplement implements DAOTemplete<PersonnelAbsenceModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(PersonnelAbsenceModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(PersonnelAbsenceModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelAbsenceModel obj) {
        return false;
    }

    @Override
    public PersonnelAbsenceModel find(int id) {
        return null;
    }

    @Override
    public List<PersonnelAbsenceModel> findAll() {
        return List.of();
    }
}
