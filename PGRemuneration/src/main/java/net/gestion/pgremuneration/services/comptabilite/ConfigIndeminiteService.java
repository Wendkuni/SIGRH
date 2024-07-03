package net.gestion.pgremuneration.services.comptabilite;


import net.gestion.pgremuneration.common.InterfaceTemplete;
import net.gestion.pgremuneration.dao.ConnectionDAO;
import net.gestion.pgremuneration.daoImplement.comptabilite.ConfigIndeminiteDAOImplement;
import net.gestion.pgremuneration.domains.comptablite.ConfigIdemitModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ConfigIndeminiteService implements InterfaceTemplete<ConfigIdemitModel> {

    private final ConfigIndeminiteDAOImplement dao=new ConfigIndeminiteDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(ConfigIdemitModel obj) {
        return dao.create(obj);
    }

    @Override
    public boolean delete(ConfigIdemitModel obj) {
        return dao.delete(obj);
    }

    @Override
    public boolean update(ConfigIdemitModel obj) {
        return dao.update(obj);
    }

    @Override
    public ConfigIdemitModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<ConfigIdemitModel> findAll() {
        return dao.findAll();
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    public boolean update(Integer id, ConfigIdemitModel m) {
        ConfigIdemitModel model = find(id);
        if(model != null) {

            return this.update(model);
        }return false;
    }
}
