package net.gestion.pgremuneration.services.parametre;


import net.gestion.pgremuneration.common.InterfaceTemplete;
import net.gestion.pgremuneration.dao.ConnectionDAO;
import net.gestion.pgremuneration.daoImplement.parametre.FonctionListeDAOImplement;
import net.gestion.pgremuneration.domains.parametres.FonctionListeModel;
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

    public List<String> ListEchelle() {
        return dao.ListEchelle();               
    }

    public List<String> ListEchelon() {
        return dao.ListEchelon();
    }

    public List<String> ListGrades() {
        return dao.ListGrade();
    }

    public List<String> LibFonction() {
        return dao.LibFonction();
    }
}
