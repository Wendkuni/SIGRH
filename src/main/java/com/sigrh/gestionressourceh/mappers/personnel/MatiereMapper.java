package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelMatieresModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatiereMapper implements RowMapper <PersonnelMatieresModel> {
    public PersonnelMatieresModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelMatieresModel.builder()
                .idMatieres(rs.getLong("IDMATIERE"))
                .libMatiere(rs.getString("libmatiere"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .build();
    }
}
