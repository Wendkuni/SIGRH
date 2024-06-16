package com.sigrh.gestionressourceh.services.comptabilite;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.comptabilite.RenumerationAgentDAOImplement;
import com.sigrh.gestionressourceh.domains.comptablite.RenumerationAgentModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RenumerationAgentService implements InterfaceTemplete<RenumerationAgentModel> {

    private final RenumerationAgentDAOImplement dao=new RenumerationAgentDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(RenumerationAgentModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(RenumerationAgentModel obj) {
        return dao.delete(obj);
    }

    @Override
    public boolean update(RenumerationAgentModel obj) {
        return dao.update(obj);
    }

    @Override
    public RenumerationAgentModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<RenumerationAgentModel> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public Double getSalaire(PersonnelModel agent) {


        return 0.0;
    }

    public boolean update(Integer id, RenumerationAgentModel m) {
        RenumerationAgentModel model = find(id);
        if(model != null) {
            model=m;
            model.setIdRenumeration(Long.valueOf(id));
            return this.update(model);
        }return false;
    }
}
