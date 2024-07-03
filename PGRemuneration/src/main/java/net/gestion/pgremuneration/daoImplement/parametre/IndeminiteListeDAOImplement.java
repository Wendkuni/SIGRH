package net.gestion.pgremuneration.daoImplement.parametre;


import net.gestion.pgremuneration.dao.DAOTemplete;
import net.gestion.pgremuneration.domains.parametres.IndeminitesListeModel;
import net.gestion.pgremuneration.mappers.parametre.IndeminitesListeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class IndeminiteListeDAOImplement implements DAOTemplete<IndeminitesListeModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public IndeminiteListeDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public boolean create(IndeminitesListeModel obj) {
        try {
            String sql = "Insert into indeminitesliste(libidnmite,IDINDEMINITES) " +
                    "values (?,?)";
            return  jdbcTemplate.update(sql,obj.getLibelleIndeminite(),obj.getIdIndeminites())!=0;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from indeminitesliste where IDINDEMINITES= ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(IndeminitesListeModel obj) {
        return false;
    }

    @Override
    public boolean update(IndeminitesListeModel obj) {
        try {
            String SQL = "update  indeminitesliste set libidnmite= ? where IDINDEMINITES = ?";
            return  jdbcTemplate.update(SQL, obj.getLibelleIndeminite(),obj.getIdIndeminites())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public IndeminitesListeModel find(int id) {
        try {
            String SQL = "select * from indeminitesliste  where IDINDEMINITES =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new IndeminitesListeMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<IndeminitesListeModel> findAll() {
        try {
            String SQL = "select * from indeminitesliste ";
            return jdbcTemplate.query(SQL,new IndeminitesListeMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
