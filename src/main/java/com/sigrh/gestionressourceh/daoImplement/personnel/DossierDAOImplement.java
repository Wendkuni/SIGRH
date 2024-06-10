package com.sigrh.gestionressourceh.daoImplement.personnel;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;

import javax.sql.DataSource;
import java.util.List;

public class DossierDAOImplement implements DAOTemplete<PersonnelDossierScanModel> {
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(PersonnelDossierScanModel obj) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean delete(PersonnelDossierScanModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelDossierScanModel obj) {
        return false;
    }

    @Override
    public PersonnelDossierScanModel find(int id) {
        return null;
    }

    @Override
    public List<PersonnelDossierScanModel> findAll() {
        return List.of();
    }
}
