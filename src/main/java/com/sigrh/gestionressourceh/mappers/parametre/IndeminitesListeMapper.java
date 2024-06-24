package com.sigrh.gestionressourceh.mappers.parametre;

import com.sigrh.gestionressourceh.domains.parametres.IndeminitesListeModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndeminitesListeMapper implements RowMapper<IndeminitesListeModel> {
    @Override
    public IndeminitesListeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return IndeminitesListeModel.builder()
                .idIndeminites(rs.getLong("IDINDEMINITES"))
                .libelleIndeminite(rs.getString("libidnmite"))
                .build();
    }
}
