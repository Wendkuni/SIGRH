package net.gestion.pgm.services.personnel;


import net.gestion.pgm.common.InterfaceTemplete;
import net.gestion.pgm.dao.ConnectionDAO;
import net.gestion.pgm.daoImplement.parametre.FonctionAgentDAOImplement;
import net.gestion.pgm.domains.personnel.PersonnelFonctionModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class FonctionAgentService implements InterfaceTemplete<PersonnelFonctionModel> {

    private  final FonctionAgentDAOImplement dao =new FonctionAgentDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(PersonnelFonctionModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(PersonnelFonctionModel obj) {
        return dao.delete(obj);
    }

    @Override
    public boolean update(PersonnelFonctionModel obj) {
        return dao.update(obj);
    }

    @Override
    public PersonnelFonctionModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelFonctionModel> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public boolean update(Integer id, PersonnelFonctionModel m) {
        PersonnelFonctionModel model = find(id);
        if(model != null) {
            model=m;
            model.setIdFonction(Long.valueOf(id));
            return this.update(model);
        }return false;
    }

	public List<PersonnelFonctionModel> findByAgent(int IDagent) {
		
		return dao.findByAgent(IDagent);
	}
}
