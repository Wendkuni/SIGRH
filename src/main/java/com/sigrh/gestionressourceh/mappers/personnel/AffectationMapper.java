package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.daoImplement.personnel.PersonnelDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffectationMapper implements RowMapper<PersonnelAffectationModel> {
    @Override
    public PersonnelAffectationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelAffectationModel.builder()
                .idAffectation(rs.getLong("IDaffectation"))
                .dateEffet(DateUtil.parseDate(rs.getString("dateffet")))
                .dren(rs.getString("DREN"))
                .localite(rs.getString("localite"))
                .notePedagogiq(rs.getLong("NOTEPEDAGOCIQ"))
                .personnel(PersonnelModel.builder().idAgent(rs.getInt("IDagent")).build())
                .serviceEcole(rs.getString("serviceecole"))
                .build();
    }
}
