package com.sigrh.gestionressourceh.services.comptabilite;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.comptabilite.IndeminiteDAOImplement;
import com.sigrh.gestionressourceh.domains.comptablite.IndeminiteModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IndeminiteService implements InterfaceTemplete<IndeminiteModel> {

    private final IndeminiteDAOImplement dao=new IndeminiteDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(IndeminiteModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(IndeminiteModel obj) {
        return dao.delete(obj);
    }

    @Override
    public boolean update(IndeminiteModel obj) {
        return dao.update(obj);
    }

    @Override
    public IndeminiteModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<IndeminiteModel> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public boolean update(Integer id, IndeminiteModel m) {
        IndeminiteModel model = find(id);
        if(model != null) {
            model=m;
            model.setIdIndeminites(id);
            return this.update(model);
        }return false;
    }
}
