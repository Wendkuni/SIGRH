package com.sigrh.gestionressourceh.mappers.parametre;

import com.sigrh.gestionressourceh.domains.parametres.FonctionListeModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FonctionListeMapper implements RowMapper<FonctionListeModel> {

    @Override
    public FonctionListeModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return FonctionListeModel.builder()
                .idFonctionListe(rs.getLong("IDFONCTIONLISTE"))
                .echelle(rs.getString("ECHELLE"))
                .echelon(rs.getString("echelon"))
                .garde(rs.getString("GRADE"))
                .indixe(rs.getString("INDIXE"))
                .libelleFonction(rs.getString("libfonctn"))
                .libelleFonctionArab(rs.getString("libfonctnarab"))
                .salaireBase(rs.getDouble("salbase"))
                .build();
    }
}
