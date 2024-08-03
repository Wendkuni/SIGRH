package net.gestion.pgrecrutement.daoImplement.personnel;

import net.gestion.pgrecrutement.dao.DAOTemplete;
import net.gestion.pgrecrutement.domains.personnel.PersonnelDossierScanModel;
import net.gestion.pgrecrutement.mappers.personnel.DossierMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class DossierDAOImplement implements DAOTemplete<PersonnelDossierScanModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public DossierDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public boolean create(PersonnelDossierScanModel obj) {
        try {
            String sql = "Insert into dossierscan(IDdossierscan,libeldossier,IDagent,observation,dateupload,imagfold) " +
                    "values (?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getIdDossierScan(), obj.getLibelDossier(),obj.getPersonnel().getIdAgent(),
                    obj.getObservation(), obj.getDateUpload(),obj.getImagFold() )!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from dossierscan where IDdossierscan = ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PersonnelDossierScanModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelDossierScanModel obj) {
       // System.out.println(obj.getLibelDossier());
        try {
            String SQL = "update  dossierscan set libeldossier= ?,observation= ?,dateupload= ?,imagfold= ?" +
                    " where IDdossierscan= ? ";
            return  jdbcTemplate.update(SQL, obj.getLibelDossier(),obj.getObservation(),
                    obj.getDateUpload(),obj.getImagFold(),obj.getIdDossierScan())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PersonnelDossierScanModel find(int id) {
        try {
            String SQL = "select * from dossierscan doss " +
                    " left join personnel p on p.IDagent =doss.IDagent " +
                    " where IDdossierscan =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new DossierMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<PersonnelDossierScanModel> findAll() {
        try {
            String SQL = "select * from dossierscan doss" +
                    " left join personnel p on p.IDagent =doss.IDagent" ;
            return jdbcTemplate.query(SQL, new DossierMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	public List<PersonnelDossierScanModel> findByAgent(int IDagent) {
        try {
            String SQL = "select * from dossierscan fction  "
                    + "left join personnel p on p.IDagent =fction.IDagent "
                    + "where fction.IDagent =?";
            return jdbcTemplate.query(SQL, new Object[]{IDagent}, new DossierMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}

}