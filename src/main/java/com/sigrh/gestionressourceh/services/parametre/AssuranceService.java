package com.sigrh.gestionressourceh.services.parametre;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.parametre.AssuranceDAOImplement;
import com.sigrh.gestionressourceh.domains.parametres.AssurancesModel;

@Service
@Transactional
public class AssuranceService  implements InterfaceTemplete<AssurancesModel>{
	private final AssuranceDAOImplement dao=new AssuranceDAOImplement(ConnectionDAO.getInstance());
	
	
	@Override
	public boolean create(AssurancesModel obj) {
		  return dao.create(obj);
	}

	@Override
	public boolean delete(AssurancesModel obj) {
		 return dao.delete(obj);
	}

	@Override
	public boolean update(AssurancesModel obj) {
		return dao.update(obj);
	}

	@Override
	public AssurancesModel find(int id) {
		return dao.find(id);
	}

	@Override
	public List<AssurancesModel> findAll() {
		return dao.findAll();
	}
	
	 public boolean delete(Integer id) {
	        return this.dao.delete(id);
	    }
	 
	 public boolean update(int id,AssurancesModel m) {
		 AssurancesModel model = find(id);
		 if(model != null) {
			 model.setDateDebut(m.getDateDebut());
			 model.setDateFin(m.getDateFin());
			 model.setEtatact(m.getEtatact());
			 model.setLibelleAssurance(m.getLibelleAssurance());
			 model.setPersonnel(m.getPersonnel());
			 model.setTypeAssurance(m.getTypeAssurance());
			 return this.update(model);
	        }return false;
		}
	public List<AssurancesModel> findByAgent(Integer id) {
		return dao.findByAgent(id);
	}
}
