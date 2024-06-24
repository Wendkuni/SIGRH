package com.sigrh.gestionressourceh.mappers.parametre;

import com.sigrh.gestionressourceh.domains.parametres.PersonnelMatieresModel;
import com.sigrh.gestionressourceh.mappers.personnel.PersonnelMapper;
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
