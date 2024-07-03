package net.gestion.pgremuneration.mappers.comptabilite;


import net.gestion.pgremuneration.common.util.DateUtil;
import net.gestion.pgremuneration.domains.comptablite.RenumerationAgentModel;
import net.gestion.pgremuneration.mappers.personnel.PersonnelMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RenumerationAgentMapper implements RowMapper<RenumerationAgentModel> {
    @Override
    public RenumerationAgentModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return RenumerationAgentModel.builder()
                .idRenumeration(rs.getLong("IDRENUMERATIONAGENT"))
                .codeBank(rs.getString("codebank"))
                .libelleBank(rs.getString("banklib"))
                .dateEffet(DateUtil.parse(rs.getString("dateeffet")))
                .valeurMontant(rs.getDouble("valmnt"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .build();
    }
}
