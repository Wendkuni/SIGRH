package com.sigrh.gestionressourceh.daoImplement.users;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.utlisateur.UtilisateurModel;
import com.sigrh.gestionressourceh.domains.utlisateur.UtilisateurRoleaModel;

import javax.sql.DataSource;
import java.util.List;

public class UserRoleDAOImplement implements DAOTemplete<UtilisateurRoleaModel> {

    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(UtilisateurRoleaModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(UtilisateurRoleaModel obj) {
        return false;
    }

    @Override
    public boolean update(UtilisateurRoleaModel obj) {
        return false;
    }

    @Override
    public UtilisateurRoleaModel find(int id) {
        return null;
    }

    @Override
    public List<UtilisateurRoleaModel> findAll() {
        return List.of();
    }

    public static List<UtilisateurRoleaModel> findByUser(UtilisateurModel user) {
        return List.of();
    }
}
