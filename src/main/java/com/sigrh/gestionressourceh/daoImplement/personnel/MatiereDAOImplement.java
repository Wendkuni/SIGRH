package com.sigrh.gestionressourceh.daoImplement.personnel;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelMatieresModel;
import com.sigrh.gestionressourceh.mappers.parametre.MatiereMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.List;

public class MatiereDAOImplement implements DAOTemplete <PersonnelMatieresModel> {


    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;
    DataSource ds ;

    public MatiereDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
         this.insert = new SimpleJdbcInsert(ds)
                .withTableName("matieres")
                .usingGeneratedKeyColumns("IDMATIERES");
    }
    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(PersonnelMatieresModel obj) {
        try {
            String sql = "INSERT INTO matieres (IDMATIERES, libmatiere, IDagent) VALUES (?, ?, ?)";
            return  jdbcTemplate.update(sql, obj.getIdMatieres(),  obj.getLibMatiere(),
                    obj.getPersonnel().getIdAgent())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from matieres where IDMATIERES = ?";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PersonnelMatieresModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelMatieresModel obj) {
        try {
            String SQL = "update  matieres set libmatiere= ?,IDagent= ?" +
                    " where IDMATIERES = ?";
            boolean b = jdbcTemplate.update(SQL, obj.getLibMatiere(),  obj.getPersonnel().getIdAgent() )!=0;
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PersonnelMatieresModel find(int id) {
        try {
            String SQL = "select * from matieres ma " +
                    " left join personnel p on p.IDagent =ma.IDagent " +
                    " where IDMATIERES =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new MatiereMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PersonnelMatieresModel> findAll() {
        try {
            String SQL = "select * from matieres ma" +
                    " left join personnel p on p.IDagent =ma.IDagent" ;

            return jdbcTemplate.query(SQL, new MatiereMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<PersonnelMatieresModel> findByAgent(int id) {
        try {
            String SQL = "select * from matieres ma " +
                    " inner join personnel p on p.IDagent =ma.IDagent " +
                    " where IDagent ="+id;
            return jdbcTemplate.query(SQL,new MatiereMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
