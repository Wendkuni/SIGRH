package net.gestion.pgremuneration.daoImplement.parametre;


import net.gestion.pgremuneration.dao.DAOTemplete;
import net.gestion.pgremuneration.domains.parametres.FonctionListeModel;
import net.gestion.pgremuneration.domains.personnel.PersonnelFonctionModel;
import net.gestion.pgremuneration.mappers.parametre.FonctionListeMapper;
import net.gestion.pgremuneration.mappers.personnel.FonctionAgentMapper;
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
    public boolean create(FonctionListeModel obj) {
        try {
            String sql = "Insert into fonctionliste(ECHELLE,echelon,GRADE,INDIXE,libfonctn,libfonctnarab,salbase,IDFONCTIONLISTE) " +
                    "values (?,?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getEchelle(),obj.getEchelon(),obj.getGrade(),obj.getIndixe(),obj.getLibelleFonction(),
                    obj.getLibelleFonctionArab(),obj.getSalaireBase(), obj.getIdFonctionListe())!=0;
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
            return  jdbcTemplate.update(SQL,obj.getEchelle(),obj.getEchelon(),obj.getGrade(),obj.getIndixe(),obj.getLibelleFonction(),
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
            String SQL = "SELECT distinct * FROM fonctionliste";
            return jdbcTemplate.query(SQL,new FonctionListeMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<String> ListEchelle() {
        try {
            String SQL = "select ECHELLE  from fonctionliste group by ECHELLE";
            return jdbcTemplate.queryForList(SQL,String.class).stream().map(String::toUpperCase).toList();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<PersonnelFonctionModel> findFonctionByAgent(int IDagent) {
        try {
            String SQL = "select * from fonctionagent fonct" +
                    " left join personnel p on p.IDagent =fonct.IDagent"
                    + " where fonct.IDagent =" + IDagent ;
            return jdbcTemplate.query(SQL, new FonctionAgentMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public List<String> ListEchelon() {
        try {
            String SQL = "select echelon  from fonctionliste group by echelon";
            return jdbcTemplate.queryForList(SQL,String.class).stream().map(String::toUpperCase).toList();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> ListGrade() {
        try {
            String SQL = "select GRADE  from fonctionliste group by GRADE";
            return jdbcTemplate.queryForList(SQL,String.class).stream().map(String::toUpperCase).toList();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> LibFonction() {
        try {
            String SQL = "select libfonctn  from fonctionliste group by libfonctn";
            return jdbcTemplate.queryForList(SQL,String.class).stream().map(String::toLowerCase).toList();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
