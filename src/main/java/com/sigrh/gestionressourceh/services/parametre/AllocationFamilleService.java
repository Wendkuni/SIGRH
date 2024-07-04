package com.sigrh.gestionressourceh.services.parametre;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.parametre.AllocationFamilleDAOImplement;
import com.sigrh.gestionressourceh.domains.parametres.AllocationFamilleModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AllocationFamilleService implements InterfaceTemplete<AllocationFamilleModel> {

    private final AllocationFamilleDAOImplement dao=new AllocationFamilleDAOImplement(ConnectionDAO.getInstance());
    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean create(AllocationFamilleModel obj) {
        return dao.create(obj);
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean delete(AllocationFamilleModel obj) {
        return dao.delete(obj);
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean update(AllocationFamilleModel obj) {
        return dao.update(obj);
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public AllocationFamilleModel find(int id) {
        return dao.find(id);
    }

    /**
     * @return 
     */
    @Override
    public List<AllocationFamilleModel> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public boolean update(int id, AllocationFamilleModel m) {
        AllocationFamilleModel model = find(id);
        if(model != null) {
            model.setEtatact(m.getEtatact());
            model.setPersonnel(m.getPersonnel());
            model.setEchelle(m.getEchelle());
            model.setEchelon(m.getEchelon());
            model.setCorpsA(m.getCorpsA());
            model.setDateEffet(m.getDateEffet());
            model.setIndexe(m.getIndexe());
            model.setRefDecret(m.getRefDecret());
            model.setNomPrenomPrise(m.getNomPrenomPrise());
            model.setDateNaissancePrise(m.getDateNaissancePrise());
            return this.update(model);
        }return false;
    }

    public List<AllocationFamilleModel> findByAgent(Integer id) {
        return dao.findByAgent(id);
    }
}
