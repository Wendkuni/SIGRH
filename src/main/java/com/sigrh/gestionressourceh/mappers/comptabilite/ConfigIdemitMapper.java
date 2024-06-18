package com.sigrh.gestionressourceh.mappers.comptabilite;

import com.sigrh.gestionressourceh.domains.comptablite.ConfigIdemitModel;
import com.sigrh.gestionressourceh.mappers.parametre.FonctionListeMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigIdemitMapper implements RowMapper<ConfigIdemitModel> {
    @Override
    public ConfigIdemitModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ConfigIdemitModel.builder()
                .idConfigIdemit(rs.getLong("IDCONFIGIDEMIT"))
                .dateCreat(rs.getDate("datecreat"))
                .valIdeminite(rs.getInt("valindeminite"))
                .libIdnmite(rs.getString("libidnmite"))
                .fonctionListe(new FonctionListeMapper().mapRow(rs,rowNum))
                .build();
    }
}
