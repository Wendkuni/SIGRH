package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.AssurancesModel;
import com.sigrh.gestionressourceh.mappers.parametre.AssuranceMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AssuranceDAOImplement implements DAOTemplete<AssurancesModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;
    
    
    public AssuranceDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }  

    @Override
    public boolean create(AssurancesModel obj) {
    	try {
            String sql = "Insert into assurances(IDASSURANCES,debutassurance,finassurance,liblassurance,etatact,typeassurance,IDagent) " +
                    "values (?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getIdAssurance(),obj.getDateDebut(),obj.getDateFin(),obj.getLibelleAssurance(),obj.getEtatact(),
                    obj.getTypeAssurance().getLabel(),obj.getPersonnel().getIdAgent())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
    	try {
            String SQL = "delete from assurances where IDASSURANCES= ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(AssurancesModel obj) {
    	try {
            String sql = "";
            return  jdbcTemplate.update(sql,"")!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(AssurancesModel obj) {
    	try {
            String sql = "update  assurances set debutassurance= ?,finassurance= ?,liblassurance= ?,etatact= ?," +
                    " typeassurance= ?,IDagent= ? where IDASSURANCES = ?";
            return  jdbcTemplate.update(sql,obj.getDateDebut(),obj.getDateFin(),obj.getLibelleAssurance(),obj.getEtatact(),
                    obj.getTypeAssurance().getLabel(),obj.getPersonnel().getIdAgent(),obj.getIdAssurance())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AssurancesModel find(int id) {
    	try {
            String SQL = "select * from assurances assu "
            		+ " left join personnel p on p.IDagent =assu.IDagent  where IDASSURANCES =?";
            return jdbcTemplate.queryForObject(SQL,new AssuranceMapper(),new Object[]{id} );
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AssurancesModel> findAll() {
    	try {
            String SQL = "select * from assurances  assu "
            		+ "left join personnel p on p.IDagent =assu.IDagent";
            return jdbcTemplate.query(SQL,new AssuranceMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
        
    }

    public List<AssurancesModel> findByAgent(Integer id) {
        try {
            String SQL = "select * from assurances  assu "
                    + "left join personnel p on p.IDagent =assu.IDagent" +
                    "where assu.IDagent="+id;
            return jdbcTemplate.query(SQL,new AssuranceMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
