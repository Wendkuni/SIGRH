package net.gestion.pgrecrutement.mappers.personnel;


import net.gestion.pgrecrutement.common.util.DateUtil;
import net.gestion.pgrecrutement.domains.personnel.PersonnelModel;
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
        personnel.setNomPrenomArab(rs.getString("nometprenomarab"));
        personnel.setNni(rs.getString("nni"));
        personnel.setDteRecrutement(DateUtil.parse(rs.getString("dterecrutmnt")));
        personnel.setDteTitularisation(DateUtil.parse(rs.getString("dtetitularisation")));
        personnel.setDteSortie(DateUtil.parse(rs.getString("dtesortie")));
        personnel.setStatusEmp(rs.getString("statusemp"));
        personnel.setTlphone(rs.getString("tlphone"));
        personnel.setAdressEmp(rs.getString("adrssemp"));
        personnel.setDebutCntrat(DateUtil.parse(rs.getString("debucntrat")));
        personnel.setFinCntrat(DateUtil.parse(rs.getString("fincntrat")));
        personnel.setDateNaiss(DateUtil.parse(rs.getString("datenaiss")));
        personnel.setLieuNaiss(rs.getString("lieunaiss"));
        personnel.setActifOrNot(rs.getBoolean("actifornot"));
        personnel.setBank(rs.getString("bank"));
        personnel.setCodeBank(rs.getString("codbank"));
        personnel.setNumroCpte(rs.getString("numrocpte"));
        personnel.setCleRib(rs.getString("clerib"));
        personnel.setDetacher(rs.getString("detacher"));
        personnel.setMinisterOrigine(rs.getString("ministerorigne"));
        personnel.setImagPers(rs.getBytes("imgpers"));
        personnel.setSexePers(rs.getString("sexepers"));
        personnel.setSituationMatri(rs.getString("situationmatri"));
        personnel.setAutres(rs.getString("autres"));
        personnel.setAutres2(rs.getString("autres2"));
        personnel.setCorpsRecrt(rs.getString("corpsrecrt"));
        personnel.setTypeF(rs.getString("typef"));
        personnel.setRefRec(rs.getString("refrec"));
        personnel.setFonctnRef(rs.getString("fonctnref"));
        personnel.setTypeeducation(rs.getString("Typeeducation"));


        return personnel;
    }

}
