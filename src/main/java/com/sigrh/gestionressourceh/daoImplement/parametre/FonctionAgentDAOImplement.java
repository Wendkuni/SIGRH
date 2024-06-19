package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelFonctionModel;
import com.sigrh.gestionressourceh.mappers.personnel.FonctionAgentMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class FonctionAgentDAOImplement implements DAOTemplete<PersonnelFonctionModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public FonctionAgentDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(PersonnelFonctionModel obj) {
        try {
            String sql = "Insert into fonctionagent(ECHELLE,echelon,GRADE,INDIXE,fonctionlib,fonctionliarab," +
                    "corpsA,CAtegoriA,IDagent,CORPSAarab,GroupeA,datefonction) " +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getEchelle(),obj.getEchelon(),obj.getGrade(),obj.getIndixe(),obj.getLibelleFonction(),
                    obj.getLibelleFonctionArab(),obj.getCorps(),obj.getCategorie(),obj.getPersonnel().getIdAgent(),
                    obj.getCorpsArab(),obj.getGroupe(),obj.getDateDebFonction())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from fonctionagent where IDFONCTIONAGENT= ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PersonnelFonctionModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelFonctionModel obj) {
        try {
            String SQL = "update  fonctionagent set ECHELLE= ?,echelon= ?,GRADE= ?,INDIXE= ?," +
                    "     fonctionlib= ?,fonctionliarab= ?, corpsA= ?,CAtegoriA= ?, IDagent= ?," +
                    " CORPSAarab= ?,GroupeA= ?,datefonction= ? where IDFONCTIONAGENT = ?";
            return  jdbcTemplate.update(SQL, obj.getEchelle(),obj.getEchelon(),obj.getGrade(),obj.getIndixe(),obj.getLibelleFonction(),
                    obj.getLibelleFonctionArab(),obj.getCorps(),obj.getCategorie(),obj.getPersonnel().getIdAgent(),
                    obj.getCorpsArab(),obj.getGroupe(),obj.getDateDebFonction(),obj.getIdFonction())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PersonnelFonctionModel find(int id) {
        try {
            String SQL = "select * from fonctionagent fction " +
                    "left join personnel p on p.IDagent =fction.IDagent " +
                    "where IDFONCTIONAGENT =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new FonctionAgentMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PersonnelFonctionModel> findAll() {
        try {
            String SQL = "select * from fonctionagent fction  " +
                    " left join personnel p on p.IDagent =fction.IDagent";
            return jdbcTemplate.query(SQL,new FonctionAgentMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
