package com.sigrh.gestionressourceh.services.personnel;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.DossierDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DossierService implements InterfaceTemplete<PersonnelDossierScanModel> {
    private final DossierDAOImplement dao=new DossierDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(PersonnelDossierScanModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(PersonnelDossierScanModel obj) {
        if (obj.getIdDossierScan()!=0)
            return dao.delete((int) obj.getIdDossierScan());
        else return false;
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    @Override
    public boolean update(PersonnelDossierScanModel obj) {
        if (obj!=null)
            return dao.update(obj);
        else return false;
    }

    @Override
    public PersonnelDossierScanModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelDossierScanModel> findAll() {
        return dao.findAll();
    }

    public boolean update(Integer id, PersonnelDossierScanModel m) {
        PersonnelDossierScanModel model = find(id);
        if(model != null) {

            return this.update(model);
        }return false;
    }
    public List<PersonnelDossierScanModel> findByAgent(int IDagent) {
        return dao.findByAgent(IDagent);
    }

}
