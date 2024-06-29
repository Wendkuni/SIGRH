package com.sigrh.gestionressourceh.daoImplement.comptabilite;

import com.sigrh.gestionressourceh.dao.DAOTemplete;
import com.sigrh.gestionressourceh.domains.comptablite.RenumerationAgentModel;
import com.sigrh.gestionressourceh.mappers.comptabilite.RenumerationAgentMapper;
import lombok.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class RenumerationAgentDAOImplement implements DAOTemplete<RenumerationAgentModel> {
    private JdbcTemplate jdbcTemplate;
    DataSource ds ;

    public RenumerationAgentDAOImplement(DataSource ds) {
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public boolean create(RenumerationAgentModel obj) {
        try {
            String sql = "Insert into renumerationagent(codebank,banklib,dateeffet,valmnt,IDagent, IDRENUMERATIONAGENT) " +
                    "values (?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getCodeBank(),obj.getLibelleBank(),obj.getDateEffet(),
                    getSalaire(obj.getPersonnel().getIdAgent()),obj.getPersonnel().getIdAgent(), obj.getIdRenumeration())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from renumerationagent where IDRENUMERATIONAGENT= ? ";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(RenumerationAgentModel obj) {
        try {
            String SQL = "delete from renumerationagent where IDRENUMERATIONAGENT= ? ";
            boolean b = jdbcTemplate.update(SQL, obj.getIdRenumeration()) != 0;
            System.out.println("Deleted Record with ID = " + obj.getIdRenumeration() );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(RenumerationAgentModel obj) {
        try {
            String SQL = "update  renumerationagent set codebank= ?,banklib= ?,dateeffet= ?,valmnt= ?," +
                    " IDagent= ? where IDRENUMERATIONAGENT = ?";
            return  jdbcTemplate.update(SQL, obj.getCodeBank(),obj.getLibelleBank(),obj.getDateEffet(),
                    obj.getValeurMontant(),obj.getPersonnel().getIdAgent(),
                    obj.getIdRenumeration())!=0;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public RenumerationAgentModel find(int id) {
         try {
            String SQL = "select * from renumerationagent renum " +
                    "left join personnel p on p.IDagent =renum.IDagent " +
                    "where IDRENUMERATIONAGENT =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new RenumerationAgentMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<RenumerationAgentModel> findAll() {
        try {
            String SQL = "select * from renumerationagent renum " +
                    " left join personnel p on p.IDagent =renum.IDagent";
            return jdbcTemplate.query(SQL,new RenumerationAgentMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Double getSalaire(long id) {
        try {
            String SQL = "select indem.valindeminite as mntIndem,fnctl.salbase as SALAIREBASE \n" +
                    "from fonctionagent fctnagen \n" +
                    "inner join indeminites indem on indem.encours!=0 and fctnagen.`IDagent`=indem.`IDagent`\n" +
                    "inner join fonctionliste fnctl on fnctl.libfonctn=fctnagen.fonctionlib\n" +
                    "and fnctl.ECHELLE=fctnagen.ECHELLE and fnctl.echelon=fctnagen.echelon\n" +
                    "and fnctl.GRADE=fctnagen.GRADE \n" +
                    "where fctnagen.IDagent=?";
            return Objects.requireNonNull(jdbcTemplate.queryForObject(SQL, new Object[]{id}, new SalaireMapper())).getTotal();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

@AllArgsConstructor @NoArgsConstructor @Builder @Getter @Setter
 class Salaire implements Serializable {
    private Integer indeminite;
    private Double salaireBase;
    private Double total;
}

class SalaireMapper implements RowMapper<Salaire> {

    @Override
    public Salaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Salaire.builder()
                .indeminite(rs.getInt("mntIndem"))
                .salaireBase(rs.getDouble("SALAIREBASE"))
                .total(Double.sum(rs.getDouble("SALAIREBASE"),rs.getInt("mntIndem")))
                .build();
    }
}