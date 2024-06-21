package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeNature;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffectationMapper implements RowMapper<PersonnelAffectationModel> {
    @Override
    public PersonnelAffectationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelAffectationModel.builder()
                .idAffectation(rs.getLong("IDaffectation"))
                .dateEffet(rs.getDate("dateffet"))
                .dren(rs.getString("DREN"))
                .localite(rs.getString("localite"))
                .notePedagogiq(rs.getLong("NOTEPEDAGOCIQ"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .serviceEcole(rs.getString("serviceecole"))
                .nature(rs.getString("nature")!=null? TypeNature.getNatureByLabel(rs.getString("nature")):TypeNature.PERMUTATION)
                .build();
    }
}
