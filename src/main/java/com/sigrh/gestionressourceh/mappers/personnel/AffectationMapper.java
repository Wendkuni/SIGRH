package com.sigrh.gestionressourceh.mappers.personnel;

import com.sigrh.gestionressourceh.common.constant.TypeNature;
import com.sigrh.gestionressourceh.common.util.DateUtil;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
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
                .situationSanit(rs.getString("situationsanit"))
                .imgSanit(rs.getBytes("imgsanit"))
                .libelDos(rs.getString("libeldoss"))
                .imgDos(rs.getBytes("imgdos"))
                .nombreFant(rs.getInt("nombrefant"))
                .ancieneteGen(rs.getInt("ancienetegen"))
                .ancienetePoste(rs.getInt("ancieneteposte"))
                .nature(rs.getString("nature")!=null? TypeNature.getNatureByLabel(rs.getString("nature")):TypeNature.PERMUTATION)
                .build();
    }
}
