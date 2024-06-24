package com.sigrh.gestionressourceh.mappers.parametre;


import com.sigrh.gestionressourceh.domains.parametres.LocaliteModel;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LocaliteMapper implements RowMapper<LocaliteModel> {
    @Override
    public LocaliteModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return LocaliteModel.builder()
                .idLocalite(rs.getLong("IDLOCALITE"))
                .libLocalite(rs.getString("liblocalite"))
                .dDren(rs.getString("ddren"))
                .province(rs.getString("province"))
                .zoneL(rs.getString("zonel"))
                .libLocaliteArab(rs.getString("liblocalitearab"))
                .dDrenwaliah(rs.getString("ddrenwaliah"))
                .provinceArab(rs.getString("provincearab"))
                .zoneLArab(rs.getString("zonelarab"))
                .codew(rs.getInt("codew"))
                .codemougkata(rs.getInt("codemougkata"))
                .priority(rs.getInt("priority"))
                .nombreDePoint(rs.getInt("nombredepoint"))
                .build();
    }

}
