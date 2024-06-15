package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.FonctionListeModel;
import com.sigrh.gestionressourceh.mappers.parametre.FonctionListeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class FonctionListeDAOImplement implements DAOTemplete<FonctionListeModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public FonctionListeDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public void setDataSource(DataSource ds) {

    }

    @Override
    public boolean create(FonctionListeModel obj) {
        try {
            String sql = "Insert into fonctionliste(ECHELLE,echelon,GRADE,INDIXE,libfonctn,libfonctnarab,salbase) " +
                    "values (?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getEchelle(),obj.getEchelon(),obj.getGarde(),obj.getIndixe(),obj.getLibelleFonction(),
                    obj.getLibelleFonctionArab(),obj.getSalaireBase())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from fonctionliste where IDFONCTIONLISTE= ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(FonctionListeModel obj) {
        return false;
    }

    @Override
    public boolean update(FonctionListeModel obj) {
        try {
            String SQL = "update  fonctionliste set ECHELLE= ?,echelon= ?,GRADE= ?,INDIXE= ?," +
                    " libfonctn= ?,libfonctnarab= ?,salbase= ? where IDFONCTIONLISTE = ?";
            return  jdbcTemplate.update(SQL,obj.getEchelle(),obj.getEchelon(),obj.getGarde(),obj.getIndixe(),obj.getLibelleFonction(),
                    obj.getLibelleFonctionArab(),obj.getSalaireBase(),obj.getIdFonctionListe())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FonctionListeModel find(int id) {
        try {
            String SQL = "select * from fonctionliste  where IDFONCTIONLISTE =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new FonctionListeMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<FonctionListeModel> findAll() {
        try {
            String SQL = "select * from fonctionliste ";
            return jdbcTemplate.query(SQL,new FonctionListeMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
