package com.sigrh.gestionressourceh.daoImplement.comptabilite;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.comptablite.ConfigIdemitModel;
import com.sigrh.gestionressourceh.mappers.comptabilite.ConfigIdemitMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ConfigIndeminiteDAOImplement implements DAOTemplete<ConfigIdemitModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public ConfigIndeminiteDAOImplement(DataSource ds) {
        this.ds = ds;
    }


    @Override
    public boolean create(ConfigIdemitModel obj) {
        try {
            String sql = "Insert into configidemit(libidnmite,valindeminite,datecreat,IDFONCTIONLISTE, IDCONFIGIDEMIT) " +
                    "values (?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getLibIdnmite(),obj.getValIdeminite(),
                    obj.getDateCreat(),obj.getFonctionListe().getIdFonctionListe(), obj.getIdConfigIdemit())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from configidemit where IDCONFIGIDEMIT = ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(ConfigIdemitModel obj) {
        try {
            String SQL = "delete from configidemit where IDCONFIGIDEMIT = ? ";
            boolean b = jdbcTemplate.update(SQL, obj.getIdConfigIdemit()) != 0;
            System.out.println("Deleted Record with ID = " + obj.getIdConfigIdemit() );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(ConfigIdemitModel obj) {
        try {
            String SQL = "update  configidemit set libidnmite= ?,valindeminite= ?,datecreat= ?,IDFONCTIONLISTE= ?" +
                    " where IDCONFIGIDEMIT = ?";
            return  jdbcTemplate.update(SQL, obj.getLibIdnmite(),obj.getValIdeminite(),
                    obj.getDateCreat(),obj.getFonctionListe().getIdFonctionListe(),obj.getIdConfigIdemit())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ConfigIdemitModel find(int id) {
        try {
            String SQL = "select * from configidemit config " +
                    " left join fonctionliste fction on fction.IDFONCTIONLISTE =config.IDFONCTIONLISTE " +
                    " where IDCONFIGIDEMIT =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ConfigIdemitMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ConfigIdemitModel> findAll() {
        try {
            String SQL = "select * from configidemit config " +
                    " left join fonctionliste fction on fction.IDFONCTIONLISTE =config.IDFONCTIONLISTE ";
            return jdbcTemplate.query(SQL, new ConfigIdemitMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
