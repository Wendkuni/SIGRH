package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelMapper implements RowMapper<PersonnelModel> {
    @Override
    public PersonnelModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        return PersonnelModel.builder()
                .actifOrNot(rs.getString("actifornot"))
                .adressEmp(rs.getString("adrssemp"))
                .bank(rs.getString("bank"))
                .cleRib(rs.getString("clerib"))
                .codeBank(rs.getString("codbank"))
                .dateNaiss(DateUtil.parseDate(rs.getString("datenaiss")))
                .debutCntrat(DateUtil.parseDate(rs.getString("debucntrat")))
                .detacher(rs.getString("detacher"))
                .dteRecrutement(DateUtil.parseDate(rs.getString("dterecrutmnt")))
                .dteSortie(DateUtil.parseDate(rs.getString("dtesortie")))
                .nni(rs.getString("nni"))
                .dteTitularisation(DateUtil.parseDate(rs.getString("dtetitularisation")))
                .idAgent(rs.getLong("IDagent"))
                .lieuNaiss(rs.getString("lieunaiss"))
                .finCntrat(DateUtil.parseDate(rs.getString("fincntrat")))
                .matricule(rs.getString("matricul"))
                .ministerOrigine(rs.getString("ministerorigne"))
                .nomPrenom(rs.getString("nometprenom"))
                .nomPrenomArab(rs.getString("nometprenomarab"))
                .numroCpte(rs.getInt("numrocpte"))
                .statusEmp(rs.getString("statusemp"))
                .tlphone(rs.getString("tlphone"))
//                .Typeeducation(rs.getString("Typeeducation")!=null&&!rs.getString("Typeeducation").isBlank()?
//                		TypeEducation.getTypeEducationByLabel(rs.getString("Typeeducation")):TypeEducation.PROFESSIONAL)
                .build();
    }

    public PersonnelModel mapRowLite(ResultSet rs, int rowNum) throws SQLException {
        PersonnelModel p = new PersonnelModel();

        return null;
    }
}
