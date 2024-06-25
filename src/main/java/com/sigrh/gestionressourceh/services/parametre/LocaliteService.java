package com.sigrh.gestionressourceh.services.parametre;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.parametre.LocaliteDAOImplement;
import com.sigrh.gestionressourceh.domains.parametres.LocaliteModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LocaliteService implements InterfaceTemplete<LocaliteModel> {

    private final LocaliteDAOImplement dao= new LocaliteDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(LocaliteModel obj) {
        return false;
    }

    @Override
    public boolean delete(LocaliteModel obj) {
        return false;
    }

    @Override
    public boolean update(LocaliteModel obj) {
        return false;
    }

    @Override
    public LocaliteModel find(int id) {
        return null;
    }

    @Override
    public List<LocaliteModel> findAll() {
        return dao.findAll();
    }
}
