package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeEducation;
import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonnelMapper implements RowMapper<PersonnelModel> {
    @Override
    public PersonnelModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        PersonnelModel personnel = new PersonnelModel();
        personnel.setIdAgent(rs.getLong("IDagent"));
        personnel.setMatricule(rs.getString("matricul"));
        personnel.setNomPrenom(rs.getString("nometprenom"));
        personnel.setNomPrenomArab(rs.getString("nometprenomArab"));
        personnel.setNni(rs.getString("nni"));
        personnel.setDteRecrutement(rs.getDate("dterecrutement"));
        personnel.setDteTitularisation(rs.getDate("dtetitularisation"));
        personnel.setDteSortie(rs.getDate("dtesortie"));
        personnel.setStatusEmp(rs.getString("statusemp"));
        personnel.setTlphone(rs.getString("tlphone"));
        personnel.setAdressEmp(rs.getString("adressemp"));
        personnel.setDebutCntrat(rs.getDate("debutcntrat"));
        personnel.setFinCntrat(rs.getDate("fincntrat"));
        personnel.setDateNaiss(rs.getDate("datenaiss"));
        personnel.setLieuNaiss(rs.getString("lieunaiss"));
        personnel.setActifOrNot(rs.getString("actifornot"));
        personnel.setBank(rs.getString("bank"));
        personnel.setCodeBank(rs.getString("codebank"));
        personnel.setNumroCpte(rs.getInt("numrocpte"));
        personnel.setCleRib(rs.getString("clerib"));
        personnel.setDetacher(rs.getString("detacher"));
        personnel.setMinisterOrigine(rs.getString("ministerorigine"));

        String typeEducation = rs.getString("Typeeducation");
        if (typeEducation != null) {
            personnel.setTypeeducation(TypeEducation.valueOf(typeEducation));
        } else {
            personnel.setTypeeducation(null);
        }

        return personnel;
    }

}
