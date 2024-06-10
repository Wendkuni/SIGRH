package com.sigrh.gestionressourceh.mappers;

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
                .adressEmp(rs.getString("adrssemp"))
//                .bank(rs.getString("bank"))
//                .clerib(rs.getString("clerib"))
//                .codbank(rs.getString("codbank"))
                .dateNaiss(DateUtil.parseToDateTime(rs.getString("datenaiss")))
                .debutCntrat(DateUtil.parse(rs.getString("debucntrat")))
//                .detacher(rs.getString("detacher"))
                .dteRecrutement(DateUtil.parseToDateTime(rs.getString("dterecrutmnt")))
                .dteSortie(DateUtil.parseToDateTime(rs.getString("dtesortie")))
                .nni(rs.getString("nni"))
                .dteTitularisation(DateUtil.parseToDateTime(rs.getString("dtetitularisation")))
                .idAgent(rs.getLong("IDagent"))
                .lieuNaiss(rs.getString("lieunaiss"))
                .finCntrat(DateUtil.parse(rs.getString("fincntrat")))
                .matricule(rs.getString("matricul"))
                .ministerOrigine(rs.getString("ministerorigne"))
                .nomPrenom(rs.getString("nometprenom"))
                .nomPrenomArab(rs.getString("nometprenomarab"))
                .numroCpte(rs.getInt("numrocpte"))
//                .statusemp(rs.getString("statusemp"))
                .tlphone(rs.getString("tlphone"))
//                .Typeeducation(rs.getString("Typeeducation")!=null&&!rs.getString("Typeeducation").isBlank()?
//                		TypeEducation.getTypeEducationByLabel(rs.getString("Typeeducation")):TypeEducation.PROFESSIONAL)
                .build();
    }
}
