package com.sigrh.gestionressourceh.services.personnel;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.AffectationDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AffectationService implements InterfaceTemplete<PersonnelAffectationModel> {
    private final AffectationDAOImplement dao= new AffectationDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(PersonnelAffectationModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(PersonnelAffectationModel obj) {
        if (obj.getIdAffectation()!=null)
        return dao.delete(obj.getIdAffectation().intValue());
        else return false;
    }
    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    @Override
    public boolean update(PersonnelAffectationModel obj) {
        if (obj!=null)
        return dao.update(obj);
        else return false;
    }

    @Override
    public PersonnelAffectationModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelAffectationModel> findAll() {
        return dao.findAll();
    }

    public boolean update(Integer id, PersonnelAffectationModel m) {
        PersonnelAffectationModel model = find(id);
        if(model != null) {

            return this.update(model);
        }return false;
    }
}
