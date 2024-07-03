package net.gestion.pgcongeabsence.services.personnel;

import net.gestion.pgcongeabsence.common.InterfaceTemplete;
import net.gestion.pgcongeabsence.dao.ConnectionDAO;
import net.gestion.pgcongeabsence.daoImplement.personnel.AbsenceDAOImplement;
import net.gestion.pgcongeabsence.domains.personnel.PersonnelAbsenceModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AbsenceService implements InterfaceTemplete<PersonnelAbsenceModel> {
    private final AbsenceDAOImplement dao=new AbsenceDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(PersonnelAbsenceModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(PersonnelAbsenceModel obj) {
        if (obj.getIdAbsence()!=0)
            return dao.delete(obj.getIdAbsence().intValue());
        else return false;
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    @Override
    public boolean update(PersonnelAbsenceModel obj) {
        if (obj!=null)
            return dao.update(obj);
        else return false;
    }

    @Override
    public PersonnelAbsenceModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelAbsenceModel> findAll() {
        return dao.findAll();
    }

    public boolean update(Integer id, PersonnelAbsenceModel m) {
        PersonnelAbsenceModel model = find(id);
        if(model != null) {
//            model=m;
//            model.setIdAbsence(Long.valueOf(id));
        	model.setAutorisation(m.getAutorisation());
        	model.setDateeffet(m.getDateeffet());
        	model.setLibelle(m.getLibelle());
        	model.setMotif(m.getMotif());
        	model.setNbJour(m.getNbJour());
        	model.setPersonnel(m.getPersonnel());
        	model.setSignataire(m.getSignataire());
            return this.update(model);
        }return false;
    }
}
