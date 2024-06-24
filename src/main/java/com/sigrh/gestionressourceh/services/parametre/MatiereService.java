package com.sigrh.gestionressourceh.services.parametre;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.MatiereDAOImplement;
import com.sigrh.gestionressourceh.domains.parametres.PersonnelMatieresModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MatiereService implements InterfaceTemplete<PersonnelMatieresModel> {
    private final MatiereDAOImplement dao= new MatiereDAOImplement(ConnectionDAO.getInstance());


    @Override
    public boolean create(PersonnelMatieresModel obj) {
        return false;
    }

    @Override
    public boolean delete(PersonnelMatieresModel obj) {
        if (obj.getIdMatieres()!=0) {
            return dao.delete((int)obj.getIdMatieres());
        }
        return false;
    }
    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }


    @Override
    public boolean update(PersonnelMatieresModel obj) {
        if (obj!=null)
            return dao.update(obj);
       else return false;
    }

    @Override
    public PersonnelMatieresModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelMatieresModel> findAll() {
        return dao.findAll();
    }
    public boolean update(Integer id, PersonnelMatieresModel m) {
        PersonnelMatieresModel model = find(id);
        if(model != null) {

            return this.update(model);
        }return false;
    }
}
