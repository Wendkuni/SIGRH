package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DossierMapper implements RowMapper<PersonnelDossierScanModel> {
    @Override
    public PersonnelDossierScanModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelDossierScanModel.builder()
                .libelDossier(rs.getString("libeldossier"))
                .dateUpload(DateUtil.parse(rs.getString("dateupload")))
                .idDossierScan(rs.getLong("IDdossierscan"))
                .observation(rs.getString("observation"))
                .imagFold(rs.getBytes("imagfold"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .build();
    }
}
