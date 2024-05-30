package com.sigrh.gestionressourceh.daoImplement;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;

import java.util.List;

public class PersonnelDAOImplement implements DAOTemplete<PersonnelModel>
{
    @Override
    public boolean create(PersonnelModel obj) {
        return false;
    }

    @Override
    public boolean delete(PersonnelModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelModel obj) {
        return false;
    }

    @Override
    public PersonnelModel find(int id) {
        return null;
    }

    @Override
    public List<PersonnelModel> findAll() {
        return List.of();
    }
}
