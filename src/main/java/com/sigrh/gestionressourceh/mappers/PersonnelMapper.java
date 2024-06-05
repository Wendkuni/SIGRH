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
        return PersonnelModel.builder()
                .actiformot(rs.getString("actifornot"))
                .adrssEmp(rs.getString("adrssemp"))
                .bank(rs.getString("bank"))
                .cleRib(rs.getString("clerib"))
                .codeBank(rs.getString("codbank"))
                .dateNaiss(DateUtil.parseToDateTime(rs.getString("datenaiss")))
                .debuCntrat(DateUtil.parse(rs.getString("debucntrat")))
                .detacher(rs.getString("detacher"))
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
                .statusEmp(rs.getString("statusemp"))
                .tlphone(rs.getString("tlphone"))
                .typeEducation(rs.getString("Typeeducation")!=null?TypeEducation.valueOf(rs.getString("Typeeducation").toUpperCase()):null)
                .build();
    }
}
