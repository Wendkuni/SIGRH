package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.FonctionListeModel;

import javax.sql.DataSource;
import java.util.List;

public class FonctionListeDAOImplement implements DAOTemplete<FonctionListeModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(FonctionListeModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(FonctionListeModel obj) {
        return false;
    }

    @Override
    public boolean update(FonctionListeModel obj) {
        return false;
    }

    @Override
    public FonctionListeModel find(int id) {
        return null;
    }

    @Override
    public List<FonctionListeModel> findAll() {
        return List.of();
    }
}
