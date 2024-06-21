package com.sigrh.gestionressourceh.daoImplement.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import com.sigrh.gestionressourceh.mappers.personnel.AffectationMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AffectationDAOImplement implements DAOTemplete<PersonnelAffectationModel> {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;
    DataSource ds ;

    public AffectationDAOImplement(DataSource ds) {
        super();
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
        this.insert = new SimpleJdbcInsert(ds)
                .withTableName("affectation")
                .usingGeneratedKeyColumns("IDaffectation");
    }

    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(PersonnelAffectationModel obj) {
        try {
            String sql = "Insert into affectation(IDaffectation,dateffet,DREN,localite,NOTEPEDAGOCIQ,IDagent,serviceecole, nature) " +
                    "values (?,?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getIdAffectation(), obj.getDateEffet(),  obj.getDren(), obj.getLocalite(),
                    obj.getNotePedagogiq(),obj.getPersonnel().getIdAgent(),obj.getServiceEcole(), obj.getNature().getLabel() )!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from affectation where IDaffectation = ?";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PersonnelAffectationModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelAffectationModel obj) {
        try {
            String SQL = "update  affectation set dateffet= ?,DREN= ?,localite= ?,NOTEPEDAGOCIQ= ?,IDagent= ?,serviceecole= ? " +
                    " where IDaffectation = ?";
            boolean b = jdbcTemplate.update(SQL, obj.getDateEffet(),  obj.getDren(), obj.getLocalite(),
                    obj.getNotePedagogiq(),obj.getPersonnel().getIdAgent(),obj.getServiceEcole(),obj.getIdAffectation() )!=0;
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PersonnelAffectationModel find(int id) {
        try {
            String SQL = "select * from affectation aff " +
                    " left join personnel p on p.IDagent =aff.IDagent " +
                    " where IDaffectation =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public List<PersonnelAffectationModel> findAll() {
        try {
           String SQL = "select * from affectation aff" +
                    " left join personnel p on p.IDagent =aff.IDagent" ;
         
            return jdbcTemplate.query(SQL, new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<PersonnelAffectationModel> findByLocalite(String localite) {
        try {
            String SQL = "select * from affectation aff " +
                    " inner join personnel p on p.IDagent =aff.IDagent" +
                    " where localite ="+localite;
            return jdbcTemplate.query(SQL,new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PersonnelAffectationModel> findByAgent(int id) {
        try {
            String SQL = "select * from affectation aff " +
                    " inner join personnel p on p.IDagent =aff.IDagent " +
                    " where IDagent ="+id;
            return jdbcTemplate.query(SQL,new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
