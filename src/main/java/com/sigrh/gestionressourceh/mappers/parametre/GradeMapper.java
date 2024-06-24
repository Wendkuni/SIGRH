package com.sigrh.gestionressourceh.mappers.parametre;

import com.sigrh.gestionressourceh.domains.parametres.GradeModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeMapper implements RowMapper<GradeModel> {
    @Override
    public GradeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return GradeModel.builder()
                .idGrade(rs.getLong("IDGRADE"))
                .categorie(rs.getString("CAtegorie"))
                .echele(rs.getString("echele"))
                .echellon(rs.getString("echellon"))
                .groupe(rs.getString("Groupe"))
                .indiceA(rs.getInt("indiceA"))
                .build();
    }
}
