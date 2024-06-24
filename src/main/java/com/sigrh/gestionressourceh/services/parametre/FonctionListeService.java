package com.sigrh.gestionressourceh.services.parametre;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.parametre.FonctionListeDAOImplement;
import com.sigrh.gestionressourceh.domains.parametres.FonctionListeModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FonctionListeService implements InterfaceTemplete<FonctionListeModel> {

    private final FonctionListeDAOImplement dao=new FonctionListeDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(FonctionListeModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(FonctionListeModel obj) {
        return dao.delete(obj);
    }

    @Override
    public boolean update(FonctionListeModel obj) {
        return dao.update(obj);
    }

    @Override
    public FonctionListeModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<FonctionListeModel> findAll() {
        return dao.findAll()
                ;
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public boolean update(Integer id, FonctionListeModel m) {
        FonctionListeModel model = find(id);
        if(model != null) {
            model=m;
            model.setIdFonctionListe(Long.valueOf(id));
            return this.update(model);
        }return false;
    }
}
