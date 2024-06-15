package com.sigrh.gestionressourceh.services.parametre;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.parametre.IndeminiteListeDAOImplement;
import com.sigrh.gestionressourceh.domains.parametres.IndeminitesListeModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class IndeminiteListeService implements InterfaceTemplete<IndeminitesListeModel> {
    private final IndeminiteListeDAOImplement dao = new IndeminiteListeDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(IndeminitesListeModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(IndeminitesListeModel obj) {
        return dao.delete(obj);
    }

    @Override
    public boolean update(IndeminitesListeModel obj) {
        return dao.update(obj);
    }

    @Override
    public IndeminitesListeModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<IndeminitesListeModel> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public boolean update(Integer id, IndeminitesListeModel m) {
        IndeminitesListeModel model = find(id);
        if(model != null) {

            return this.update(model);
        }return false;
    }
}
