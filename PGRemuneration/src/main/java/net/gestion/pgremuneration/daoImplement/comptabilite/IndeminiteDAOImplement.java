package net.gestion.pgremuneration.daoImplement.comptabilite;


import net.gestion.pgremuneration.dao.DAOTemplete;
import net.gestion.pgremuneration.domains.comptablite.IndeminiteModel;
import net.gestion.pgremuneration.mappers.comptabilite.IndeminiteMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class IndeminiteDAOImplement implements DAOTemplete<IndeminiteModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public IndeminiteDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }


    @Override
    public boolean create(IndeminiteModel obj) {
        try {
            String sql = "Insert into indeminites(encours,etatact,dateffet,fctionlib,grade,IDagent,libidnmite,valindeminite, IDINDEMINITES) " +
                    "values (?,?,?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getEncours(),obj.getEtatact(),
                    obj.getDateEffet(),obj.getFctionLibelle(),obj.getGrade(),obj.getPersonnel().getIdAgent(),
                    obj.getLibelleIndeminite(),obj.getValeurIndeminite(), obj.getIdIndeminites())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from indeminites where IDINDEMINITES= ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(IndeminiteModel obj) {
        return false;
    }

    @Override
    public boolean update(IndeminiteModel obj) {
        try {
            String SQL = "update  indeminites set encours= ?,etatact= ?,dateffet= ?,fctionlib= ?,grade= ?,IDagent= ?,libidnmite= ?,valindeminite= ?" +
                    " where IDINDEMINITES = ?";
            return  jdbcTemplate.update(SQL, obj.getEncours(),obj.getEtatact(),
                    obj.getDateEffet(),obj.getFctionLibelle(),obj.getGrade(),obj.getPersonnel().getIdAgent(),
                    obj.getLibelleIndeminite(),obj.getValeurIndeminite(),obj.getIdIndeminites())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public IndeminiteModel find(int id) {
        try {
            String SQL = "select * from indeminites inde " +
                    " left join personnel p on p.IDagent =inde.IDagent " +
                    " where IDINDEMINITES =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new IndeminiteMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<IndeminiteModel> findAll() {
        try {
            String SQL = "select * from indeminites inde " +
                    " left join personnel p on p.IDagent =inde.IDagent ";
            return jdbcTemplate.query(SQL,new IndeminiteMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
