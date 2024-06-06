package com.sigrh.gestionressourceh.mappers;

import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelMapper implements RowMapper<PersonnelModel> {
    @Override
    public PersonnelModel mapRow(ResultSet rs, int rowNum) throws SQLException {
    	System.out.println(rs.getString("Typeeducation"));
        return PersonnelModel.builder()
//                .actifornot(rs.getString("actifornot"))
                .adressemp(rs.getString("adrssemp"))
//                .bank(rs.getString("bank"))
//                .clerib(rs.getString("clerib"))
//                .codbank(rs.getString("codbank"))
                .datenaiss(DateUtil.parseToDateTime(rs.getString("datenaiss")))
                .debutcntrat(DateUtil.parse(rs.getString("debucntrat")))
//                .detacher(rs.getString("detacher"))
                .dterecrutement(DateUtil.parseToDateTime(rs.getString("dterecrutmnt")))
                .dtesortie(DateUtil.parseToDateTime(rs.getString("dtesortie")))
                .nni(rs.getString("nni"))
                .dtetitularisation(DateUtil.parseToDateTime(rs.getString("dtetitularisation")))
                .idAgent(rs.getLong("IDagent"))
                .lieunaiss(rs.getString("lieunaiss"))
                .fincntrat(DateUtil.parse(rs.getString("fincntrat")))
                .matricule(rs.getString("matricul"))
                .ministerorigine(rs.getString("ministerorigne"))
                .nometprenom(rs.getString("nometprenom"))
                .nometprenomarab(rs.getString("nometprenomarab"))
                .numrocpte(rs.getInt("numrocpte"))
//                .statusemp(rs.getString("statusemp"))
                .tlphone(rs.getString("tlphone"))
//                .Typeeducation(rs.getString("Typeeducation")!=null&&!rs.getString("Typeeducation").isBlank()?
//                		TypeEducation.getTypeEducationByLabel(rs.getString("Typeeducation")):TypeEducation.PROFESSIONAL)
                .build();
    }
}
