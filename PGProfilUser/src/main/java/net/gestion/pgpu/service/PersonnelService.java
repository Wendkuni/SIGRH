package net.gestion.pgpu.service;

import net.gestion.pgpu.common.InterfaceTemplete;
import net.gestion.pgpu.dao.ConnectionDAO;
import net.gestion.pgpu.daoImplement.PersonnelDAOImplement;
import net.gestion.pgpu.domaine.personnel.PersonnelModel;
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
        return this.daoImplement.update(obj);
    }

    @Override
    public PersonnelModel find(int id) {
        return this.daoImplement.find(id);
    }

    @Override
    public List<PersonnelModel> findAll() {
        return this.daoImplement.findAll();
    }

    public boolean delete(Integer id) {
        return this.daoImplement.delete(id);
    }

    public boolean update(Integer id, PersonnelModel m) {
        PersonnelModel model = find(id);
        if(model != null) {
            model.setNni(m.getNni());
            model.setNomPrenom(m.getNomPrenom());
            model.setMatricule(m.getMatricule());
            return this.update(model);
        }
        return false;
    }

}
