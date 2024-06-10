package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DossierMapper implements RowMapper<PersonnelDossierScanModel> {
    @Override
    public PersonnelDossierScanModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelDossierScanModel.builder()
                .libelDossier(rs.getString("libeldossier"))
                .dateUpload(DateUtil.parseDate(rs.getString("dateupload")))
                .idDossierScan(rs.getLong("IDdossier"))
                .observation(rs.getString("observation"))
                .imageFold(rs.getString("imagefold"))
                .personnel(PersonnelModel.builder().idAgent(rs.getInt("IDagent")).build())
                .build();
    }
}
