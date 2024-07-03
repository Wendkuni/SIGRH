package net.gestion.pgremuneration.services.comptabilite;


import net.gestion.pgremuneration.common.InterfaceTemplete;
import net.gestion.pgremuneration.dao.ConnectionDAO;
import net.gestion.pgremuneration.daoImplement.comptabilite.RenumerationAgentDAOImplement;
import net.gestion.pgremuneration.domains.comptablite.RenumerationAgentModel;
import net.gestion.pgremuneration.domains.personnel.PersonnelModel;
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
