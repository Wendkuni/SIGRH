package net.gestion.pgm.mappers.personnel;


import net.gestion.pgm.common.constant.TypeDistinction;
import net.gestion.pgm.common.constant.TypeNature;
import net.gestion.pgm.common.util.DateUtil;
import net.gestion.pgm.domains.personnel.PersonnelAffectationModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AffectationMapper implements RowMapper<PersonnelAffectationModel> {
    @Override
    public PersonnelAffectationModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        return PersonnelAffectationModel.builder()
                .idAffectation(rs.getLong("IDaffectation"))
                .dateEffet(DateUtil.parse(rs.getString("dateffet")))
                .dren(rs.getString("DREN"))
                .localite(rs.getString("localite"))
                .notePedagogiq(rs.getLong("NOTEPEDAGOCIQ"))
                .personnel(new PersonnelMapper().mapRow(rs,rowNum))
                .serviceEcole(rs.getString("serviceecole"))
                .motif(rs.getString("motif"))
                .nature(TypeNature.valueOf(rs.getString("nature")))
                .situationSanit(rs.getString("situationsanit"))
                .imgSanit(rs.getBytes("imgsanit"))
                .libelDos(rs.getString("libeldoss"))
                .imgDos(rs.getBytes("imgdos"))
                .nombreFant(rs.getInt("nombrefant"))
                .ancieneteGen(rs.getInt("ancienetegen"))
                .ancienetePoste(rs.getInt("ancieneteposte"))
                .posteOrigin(rs.getString("posteorigin"))
                .posteDestinat1(rs.getString("postedestinat1"))
                .posteDestinat2(rs.getString("postedestinat2"))
                .posteDestinat3(rs.getString("postedestinat3"))
                .posteDestinat4(rs.getString("postedestinat4"))
                .posteDestinat5(rs.getString("postedestinat5"))
                .distinction(rs.getString("distinctions")!=null? TypeDistinction.getDistinctionByLabel(rs.getString("distinctions")):TypeDistinction.NATIONAL)
                .regroupementConjoint(rs.getString("regroupconjoint"))
                .autresSocial(rs.getString("autressocial"))
                .noteAdministrative(rs.getInt("noteadminitrative"))
                .situationMatrimo(rs.getString("situationmatrimo"))
                .etatAffect(rs.getString("etataffect"))
                .pointsPondere(rs.getFloat("pointspondere"))
                .autresDiplome(rs.getString("autresdiplomes"))
                .build();


    }
}
