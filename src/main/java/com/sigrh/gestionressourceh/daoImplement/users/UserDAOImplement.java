package com.sigrh.gestionressourceh.daoImplement.users;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.utlisateur.UtilisateurModel;

import javax.sql.DataSource;
import java.util.List;

public class UserDAOImplement implements DAOTemplete<UtilisateurModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(UtilisateurModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(UtilisateurModel obj) {
        return false;
    }

    @Override
    public boolean update(UtilisateurModel obj) {
        return false;
    }

    @Override
    public UtilisateurModel find(int id) {
        return null;
    }

    @Override
    public List<UtilisateurModel> findAll() {
        return List.of();
    }

    public static UtilisateurModel findByUserName(String nomPrenom) {
        return null;
    }
}
