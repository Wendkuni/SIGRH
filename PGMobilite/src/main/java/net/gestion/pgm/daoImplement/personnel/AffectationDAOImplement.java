package net.gestion.pgm.daoImplement.personnel;


import net.gestion.pgm.common.constant.TypeDistinction;
import net.gestion.pgm.dao.DAOTemplete;
import net.gestion.pgm.domains.personnel.PersonnelAffectationModel;
import net.gestion.pgm.domains.personnel.PersonnelDossierScanModel;
import net.gestion.pgm.mappers.personnel.AffectationMapper;
import net.gestion.pgm.mappers.personnel.DossierMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AffectationDAOImplement implements DAOTemplete<PersonnelAffectationModel> {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;
    DataSource ds ;

    public AffectationDAOImplement(DataSource ds) {
        super();
        this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
        this.insert = new SimpleJdbcInsert(ds)
                .withTableName("affectation")
                .usingGeneratedKeyColumns("IDaffectation");
    }


    @Override
    public boolean create(PersonnelAffectationModel obj) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("dateffet", obj.getDateEffet());
            params.put("DREN",obj.getDren() );
            params.put("localite",obj.getLocalite() );
            params.put("NOTEPEDAGOCIQ",obj.getNotePedagogiq() );
            params.put("IDagent",obj.getPersonnel().getIdAgent() );
            params.put("serviceecole",obj.getServiceEcole() );
            params.put("motif",obj.getMotif() );
            params.put("nature",obj.getNature());
            params.put("situationsanit",obj.getSituationSanit() );
            params.put("imgsanit",obj.getImgSanit() );
            params.put("libeldoss",obj.getLibelDos() );
            params.put("imgdos",obj.getImgDos() );
            params.put("nombrefant",obj.getNombreFant( ));
            params.put("ancienetegen",  obj.getAncienetePoste());
            params.put("posteorigin", obj.getPosteOrigin());
            params.put("postedestinat1",obj.getPosteDestinat1() );
            params.put("postedestinat2",obj.getPosteDestinat2() );
            params.put("postedestinat3", obj.getPosteDestinat3());
            params.put("postedestinat4",obj.getPosteDestinat4());
            params.put("postedestinat5",obj.getPosteDestinat5());
            params.put("distinctions",obj.getDistinction()!=null?obj.getDistinction().getLabel(): TypeDistinction.NATIONAL.getLabel());
            params.put("regroupconjoint", obj.getRegroupementConjoint());
            params.put("autressocial", obj.getAutresSocial());
            params.put("noteadminitrative",obj.getNoteAdministrative());
            params.put("situationmatrimo",obj.getSituationMatrimo());
            params.put("etataffect",obj.getEtatAffect());
            params.put("pointspondere",obj.getPointsPondere());
            params.put("autresdiplome",obj.getAutresDiplome());
            Number newId = insert.executeAndReturnKey(params);
            obj.setIdAffectation(newId.longValue());

            return newId.intValue()!=0;
            /*String sql = "Insert into affectation(IDaffectation,dateffet,DREN,localite,NOTEPEDAGOCIQ,IDagent,serviceecole,motif,situationsanit,imgsanit,libeldoss,imgdos,nombrefant,ancienetegen,ancieneteposte,posteorigin,postedestinat1,postedestinat2,postedestinat3) " +
                    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            return  jdbcTemplate.update(sql,obj.getIdAffectation(), obj.getDateEffet(),  obj.getDren(), obj.getLocalite(),
                    obj.getNotePedagogiq(),obj.getPersonnel().getIdAgent(),obj.getServiceEcole(),
                    obj.getMotif(), obj.getSituationSanit(), obj.getImgSanit(), obj.getLibelDos(), obj.getImgDos(), obj.getNombreFant(),
                    obj.getAncieneteGen(), obj.getAncienetePoste(), obj.getPosteOrigin(),obj.getPosteDestinat1(),obj.getPosteDestinat2(),obj.getPosteDestinat3() )!=0;*/
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public boolean delete(int id) {
        try {
            String SQL = "delete from affectation where IDaffectation = ?";
            boolean b = jdbcTemplate.update(SQL, id) != 0;
            System.out.println("Deleted Record with ID = " + id );
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(PersonnelAffectationModel obj) {
        return false;
    }

    @Override
    public boolean update(PersonnelAffectationModel obj) {
        try {
            String SQL = "update  affectation set dateffet= ?,DREN= ?,localite= ?,NOTEPEDAGOCIQ= ?,IDagent= ?,serviceecole= ?, nature=?,motif=?,situationsanit=?,imgsanit=?,libeldoss=?,imgdos=?,nombrefant=?,ancienetegen=?,ancieneteposte=?,posteorigin=?,postedestinat1=?,postedestinat2=?,postedestinat3=?,postedestinat4=?,postedestinat5=?,distinctions=?,regroupconjoint=?,autressocial=?,noteadminitrative=?,situationmatrimo=?, etataffect=?, pointspondere=?, autresdiplomes=?, nature=? " +
                    " where IDaffectation = ?";
            boolean b = jdbcTemplate.update(SQL, obj.getDateEffet(),  obj.getDren(), obj.getLocalite(),
                    obj.getNotePedagogiq(),obj.getPersonnel().getIdAgent(),obj.getServiceEcole(),
                    obj.getMotif(), obj.getSituationSanit(), obj.getImgSanit(), obj.getLibelDos(),
                    obj.getImgDos(), obj.getNombreFant(),
                    obj.getAncieneteGen(), obj.getAncienetePoste(),obj.getPosteOrigin(),
                    obj.getPosteDestinat1(),obj.getPosteDestinat2(),
                    obj.getPosteDestinat3(), obj.getPosteDestinat4(),
                    obj.getPosteDestinat5(),obj.getDistinction(),
                    obj.getRegroupementConjoint(),obj.getAutresSocial(),
                    obj.getNoteAdministrative(),obj.getSituationMatrimo(),
                    obj.getEtatAffect(), obj.getPointsPondere(), obj.getAutresDiplome(),
                    obj.getNature(),
                    obj.getIdAffectation() )!=0;
            return b;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public PersonnelAffectationModel find(int id) {
        try {
            String SQL = "select * from affectation aff " +
                    " left join personnel p on p.IDagent =aff.IDagent " +
                    " where IDaffectation =?";
            return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public List<PersonnelAffectationModel> findAll() {
        try {
           String SQL = "select * from affectation aff" +
                    " left join personnel p on p.IDagent =aff.IDagent" ;
         
            return jdbcTemplate.query(SQL, new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<PersonnelAffectationModel> findByLocalite(String localite) {
        try {
            String SQL = "select * from affectation aff " +
                    " inner join personnel p on p.IDagent =aff.IDagent" +
                    " where localite ="+localite;
            return jdbcTemplate.query(SQL,new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<PersonnelAffectationModel> findByAgent(int IDagent) {
        try {
            String SQL = "select * from affectation aff " +
                    " left join personnel p on p.IDagent =aff.IDagent " +
                    " where aff.IDagent = ?";
            return jdbcTemplate.query(SQL,new Object[]{IDagent},new AffectationMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<PersonnelDossierScanModel> getDossierByAffectation(PersonnelAffectationModel obj) {
        try {
            String SQL = "select * from dossierscan doss" +
                    " inner join personnel p on p.IDagent =doss.IDagent " +
                    "where doss.refsaffectation="+obj.getIdAffectation()+" and p.IDagent ="+obj.getPersonnel().getIdAgent() ;
            return jdbcTemplate.query(SQL, new DossierMapper());
        }catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }


}
