package net.gestion.pgremuneration.mappers.comptabilite;


import net.gestion.pgremuneration.common.util.DateUtil;
import net.gestion.pgremuneration.domains.comptablite.IndeminiteModel;
import net.gestion.pgremuneration.mappers.personnel.PersonnelMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndeminiteMapper implements RowMapper<IndeminiteModel> {
    @Override
    public IndeminiteModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return IndeminiteModel.builder()
                .idIndeminites(rs.getLong("IDINDEMINITES"))
                .dateEffet(DateUtil.parse(rs.getString("dateffet")))
                .encours(rs.getBoolean("encours"))
                .etatact(rs.getString("etatact"))
                .fctionLibelle(rs.getString("fctionlib"))
                .grade(rs.getString("grade"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .libelleIndeminite(rs.getString("libidnmite"))
                .valeurIndeminite(rs.getInt("valindeminite"))
                .build();
    }
}
