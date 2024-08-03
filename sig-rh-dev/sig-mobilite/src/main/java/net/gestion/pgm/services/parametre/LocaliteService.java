package net.gestion.pgm.services.parametre;


import net.gestion.pgm.common.InterfaceTemplete;
import net.gestion.pgm.dao.ConnectionDAO;
import net.gestion.pgm.daoImplement.parametre.LocaliteDAOImplement;
import net.gestion.pgm.domains.parametres.LocaliteModel;
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

    public List<String> ListeLocalite() {
        return dao.ListeLocalite();
    }

    public List<String> ListeCodew() {
        return dao.ListeCodeW();
    }

    public List<String> ListePriority() {
        return dao.ListePriority();
    }

    public List<String> ListeNombrePoint() {
        return dao.ListeNombrePoint();
    }

    public List<String> ListeCodeMougkata() {
        return dao.ListeCodeMougkata();
    }
}
