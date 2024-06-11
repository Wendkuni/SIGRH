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
                .dateNaiss(rs.getDate("datenaiss"))
                .debutCntrat(rs.getDate("debucntrat"))
                .detacher(rs.getString("detacher"))
                .dteRecrutement(rs.getDate("dterecrutmnt"))
                .dteSortie(rs.getDate("dtesortie"))
                .nni(rs.getString("nni"))
                .dteTitularisation(rs.getDate("dtetitularisation"))
                .idAgent(rs.getLong("IDagent"))
                .lieuNaiss(rs.getString("lieunaiss"))
                .finCntrat(rs.getDate("fincntrat"))
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

}
