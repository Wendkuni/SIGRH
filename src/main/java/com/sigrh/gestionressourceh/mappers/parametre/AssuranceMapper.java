package com.sigrh.gestionressourceh.mappers.parametre;

import com.sigrh.gestionressourceh.common.constant.TypeAssurance;
import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.parametres.AssurancesModel;
import com.sigrh.gestionressourceh.mappers.personnel.PersonnelMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssuranceMapper implements RowMapper<AssurancesModel> {
    @Override
    public AssurancesModel mapRow(ResultSet rs, int rowNum) throws SQLException {
    	String type = rs.getString("typeassurance");

        return AssurancesModel.builder()
                .idAssurance(rs.getLong("IDASSURANCES"))
                .dateDebut(DateUtil.parse(rs.getString("debutassurance")))
                .dateFin(DateUtil.parse(rs.getString("finassurance")))
                .libelleAssurance(rs.getString("liblassurance"))
                .etatact(rs.getString("etatact"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .typeAssurance(type!=null&&!type.isBlank()?
                		TypeAssurance.getTypeAssuranceByLabel(type):TypeAssurance.AUCUN)
                .build();
    }
}
