package com.sigrh.gestionressourceh.daoImplement.personnel;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAbsenceModel;
import com.sigrh.gestionressourceh.mappers.personnel.AbsenceMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AbsenceDAOImplement implements DAOTemplete<PersonnelAbsenceModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public AbsenceDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(PersonnelAbsenceModel obj) {
        try {
            String sql = "Insert into absencea(autorisation,IDagent,dateeffet,motif,libelleab,nombrejr,signataire) " +
                    "values (?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql, obj.getAutorisation(),  obj.getPersonnel().getIdAgent(),
                    obj.getDateeffet(), obj.getMotif(),obj.getLibelle(),obj.getNbJour(),obj.getSignataire())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from absencea where IDABSENCEA = ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PersonnelAbsenceModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelAbsenceModel obj) {
        try {
            String SQL = "update  absencea set autorisation= ?,IDagent= ?,dateeffet= ?,motif= ?,libelleab=?,nombrejr= ?,signataire= ?" +
                    " where IDABSENCEA = ?";
            return  jdbcTemplate.update(SQL, obj.getAutorisation(),  obj.getPersonnel().getIdAgent(),
                    obj.getDateeffet(), obj.getMotif(),obj.getLibelle(),obj.getNbJour(),obj.getSignataire(),obj.getIdAbsence())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PersonnelAbsenceModel find(int id) {
        try {
            String SQL = "select * from absencea abs " +
                    " left join personnel p on p.IDagent =abs.IDagent " +
                    " where IDABSENCEA =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new AbsenceMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PersonnelAbsenceModel> findAll() {
        try {
            String SQL = "select * from absencea abs" +
                    " left join personnel p on p.IDagent =abs.IDagent" ;
            return jdbcTemplate.query(SQL, new AbsenceMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
