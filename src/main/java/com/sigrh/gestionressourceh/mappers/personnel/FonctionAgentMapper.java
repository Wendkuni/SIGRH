package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelFonctionModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FonctionAgentMapper implements RowMapper<PersonnelFonctionModel> {
    @Override
    public PersonnelFonctionModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelFonctionModel.builder()
                .echelle(rs.getString("ECHELLE"))
                .echelon(rs.getString("echelon"))
                .grade(rs.getString("GRADE"))
                .indixe(rs.getString("INDIXE"))
                .libelleFonction(rs.getString("fonctionlib"))
                .libelleFonctionArab(rs.getString("fonctionliarab"))
                .idFonction(rs.getLong("IDFONCTIONAGENT"))
                .corps(rs.getString("corpsA"))
                .categorie(rs.getString("CAtegoriA"))
                .corpsArab(rs.getString("CORPSAarab"))
                .groupe(rs.getString("GroupeA"))
                .dateDebFonction(DateUtil.parse(rs.getString("datefonction")))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .build();
    }
}
