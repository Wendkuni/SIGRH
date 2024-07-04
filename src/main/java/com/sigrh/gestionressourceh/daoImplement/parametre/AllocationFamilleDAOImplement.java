package com.sigrh.gestionressourceh.daoImplement.parametre;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.parametres.AllocationFamilleModel;
import com.sigrh.gestionressourceh.mappers.parametre.AllocationMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AllocationFamilleDAOImplement implements DAOTemplete<AllocationFamilleModel> {


    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public AllocationFamilleDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean create(AllocationFamilleModel obj) {

        try {
            String SQL = " Insert into allocationfamille(echele,echelon,index,corspa,NOMPRENOMPrise," +
                    "dateeffet,datenaissPrise,refdecret,etatact,IDagent,IDALLOCATIONFAMILLE)" +
                    "values (?,?,?,?,?,?,?,?,?,?,?)";
            return jdbcTemplate.update(SQL,obj.getEchelle(),obj.getEchelon(),obj.getIndexe(),obj.getCorpsA(),obj.getNomPrenomPrise(),
                    obj.getDateEffet(),obj.getDateNaissancePrise(),obj.getRefDecret(),obj.getEtatact(), obj.getPersonnel().getIdAgent(),obj.getIdAllocation()) != 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from allocationfamille where IDALLOCATIONFAMILLE= ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean delete(AllocationFamilleModel obj) {
        try {
            String SQL = "delete from allocationfamille where IDALLOCATIONFAMILLE= ? ";
            return jdbcTemplate.update(SQL, obj.getIdAllocation()) != 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param obj 
     * @return
     */
    @Override
    public boolean update(AllocationFamilleModel obj) {
        try {
            String SQL = "update  allocationfamille set echele= ? ,echelon= ?,index= ?,corspa= ?,NOMPRENOMPrise= ?" +
                    "dateeffet= ?,datenaissPrise= ?,refdecret= ?,etatact= ?,IDagent= ?  where IDALLOCATIONFAMILLE= ?";
            return jdbcTemplate.update(SQL, obj.getEchelle(),obj.getEchelon(),obj.getIndexe(),obj.getCorpsA(),obj.getNomPrenomPrise(),
                    obj.getDateEffet(),obj.getDateNaissancePrise(),obj.getRefDecret(),obj.getEtatact(), obj.getPersonnel().getIdAgent(),obj.getIdAllocation()) != 0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param id 
     * @return
     */
    @Override
    public AllocationFamilleModel find(int id) {
        try {
            String SQL = "select * from  allocationfamille all" +
                    " left join personnel p on p.IDagent =all.IDagent  where IDALLOCATIONFAMILLE =?";
            return jdbcTemplate.queryForObject(SQL, new AllocationMapper(),new Object[]{id}) ;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * @return 
     */
    @Override
    public List<AllocationFamilleModel> findAll() {
        try {
            String SQL = "select * from  allocationfamille all" +
                    " left join personnel p on p.IDagent =all.IDagent ";
            return jdbcTemplate.query(SQL, new AllocationMapper()) ;
        }catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }

    }

    public List<AllocationFamilleModel> findByAgent(Integer id) {
        try {
            String SQL = "select * from  allocationfamille all" +
                    " left join personnel p on p.IDagent =all.IDagent where all.IDagent =?";
            return jdbcTemplate.query(SQL, new AllocationMapper()) ;
        }catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
