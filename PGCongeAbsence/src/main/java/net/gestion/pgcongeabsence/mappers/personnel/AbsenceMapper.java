package net.gestion.pgcongeabsence.mappers.personnel;


import net.gestion.pgcongeabsence.common.util.DateUtil;
import net.gestion.pgcongeabsence.domains.personnel.PersonnelAbsenceModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AbsenceMapper implements RowMapper<PersonnelAbsenceModel> {
    @Override
    public PersonnelAbsenceModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelAbsenceModel.builder()
                .idAbsence(rs.getLong("IDABSENCEA"))
                .autorisation(rs.getString("autorisation"))
                .motif(rs.getString("motif"))
                .dateeffet(DateUtil.parse(rs.getString("dateeffet")))
                .libelle(rs.getString("libelleab"))
                .nbJour(rs.getInt("nombrejr"))
                .signataire(rs.getString("signataire"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .build();
    }
}
