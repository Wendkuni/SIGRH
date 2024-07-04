package com.sigrh.gestionressourceh.mappers.parametre;

import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.parametres.AllocationFamilleModel;
import com.sigrh.gestionressourceh.mappers.personnel.PersonnelMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AllocationMapper implements RowMapper<AllocationFamilleModel> {
    /**
     * @param rs     the {@code ResultSet} to map (pre-initialized for the current row) 
     * @param rowNum the number of the current row
     * @return
     * @throws SQLException
     */
    @Override
    public AllocationFamilleModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return AllocationFamilleModel.builder()
                .echelle(rs.getString("echele"))
                .echelon(rs.getString("echelon"))
                .indexe(rs.getString("index"))
                .corpsA(rs.getString("corspa"))
                .nomPrenomPrise(rs.getString("NOMPRENOMPrise"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .idAllocation(rs.getLong("IDALLOCATIONFAMILLE"))
                .dateEffet(DateUtil.parse(rs.getString("dateeffet")))
                .dateNaissancePrise(DateUtil.parse(rs.getString("datenaissPrise")))
                .refDecret(rs.getString("refdecret"))
                .etatact(rs.getString("etatact"))
                .build();
    }
}
