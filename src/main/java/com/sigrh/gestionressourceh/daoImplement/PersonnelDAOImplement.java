package com.sigrh.gestionressourceh.daoImplement;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import com.sigrh.gestionressourceh.mappers.PersonnelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonnelDAOImplement implements DAOTemplete<PersonnelModel>
{
    private SimpleJdbcCall procRead;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;
    DataSource ds ;
    
    public PersonnelDAOImplement(DataSource ds) {
		super();
		this.ds = ds;
		this.insert = new SimpleJdbcInsert(ds)
                .withTableName("personnel")
                .usingGeneratedKeyColumns("IDagent");
	}

	@Override
    public void setDataSource(DataSource ds) {
//        this.insert = new SimpleJdbcInsert(ds)
//                .withTableName("personnel")
//                .usingGeneratedKeyColumns("IDagent");
    }

    @Override
    public boolean create(PersonnelModel obj) {
        try {
            String sql = "Insert into personnel(nometprenom,matricule,nni) values (?, ?, ?)";
            return  jdbcTemplate.update(sql, obj.getNomPrenom(),  obj.getMatricule(), obj.getNni())!=0;
        }catch (Exception e) {
           e.printStackTrace();
            return false;
        }

    }

    public boolean add(PersonnelModel obj) {
        Map<String, Object> params = new HashMap<>();
        params.put("nometprenom", obj.getNomPrenom());
        params.put("matricul", obj.getMatricule());
        params.put("nni", obj.getNni());
        Number newId = insert.executeAndReturnKey(params);
        obj.setIdAgent(newId.intValue());
       return true;
    }
    @Override
    public boolean delete(PersonnelModel obj) {
        String SQL = "delete from Student where IDagent = ?";
        boolean b = jdbcTemplate.update(SQL, obj.getIdAgent()) != 0;
        System.out.println("Deleted Record with ID = " + obj.getIdAgent() );
        return b;
    }

    @Override
    public boolean update(PersonnelModel obj) {
        String SQL = "select * from personnel where IDagent = ?";
        boolean b = jdbcTemplate.update(SQL, obj.getNomPrenom(), obj.getMatricule(), obj.getNni()) != 0;
        return b;
    }

    @Override
    public PersonnelModel find(int id) {
        String SQL = "select * from personnel where IDagent =?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new PersonnelMapper());
    }

    @Override
    public List<PersonnelModel> findAll() {
        String SQL = "select * from personnel";
        return jdbcTemplate.query(SQL,new PersonnelMapper());
    }


}
