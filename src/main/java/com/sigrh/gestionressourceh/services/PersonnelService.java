package com.sigrh.gestionressourceh.services;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.PersonnelDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonnelService implements InterfaceTemplete<PersonnelModel> {

   private final PersonnelDAOImplement daoImplement= new PersonnelDAOImplement(ConnectionDAO.getInstance());


    @Override
    public boolean create(PersonnelModel obj) {
        return this.daoImplement.add(obj);
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
