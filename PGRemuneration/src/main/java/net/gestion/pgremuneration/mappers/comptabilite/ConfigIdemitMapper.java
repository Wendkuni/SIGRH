package net.gestion.pgremuneration.mappers.comptabilite;


import net.gestion.pgremuneration.common.util.DateUtil;
import net.gestion.pgremuneration.domains.comptablite.ConfigIdemitModel;
import net.gestion.pgremuneration.mappers.parametre.FonctionListeMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfigIdemitMapper implements RowMapper<ConfigIdemitModel> {
    @Override
    public ConfigIdemitModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ConfigIdemitModel.builder()
                .idConfigIdemit(rs.getLong("IDCONFIGIDEMIT"))
                .dateCreat(DateUtil.parse(rs.getString("datecreat")))
                .valIdeminite(rs.getInt("valindeminite"))
                .libIdnmite(rs.getString("libidnmite"))
                .fonctionListe(new FonctionListeMapper().mapRow(rs,rowNum))
                .build();
    }
}
