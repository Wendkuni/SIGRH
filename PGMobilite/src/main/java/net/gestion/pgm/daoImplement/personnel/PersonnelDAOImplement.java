package net.gestion.pgm.daoImplement.personnel;



import net.gestion.pgm.dao.DAOTemplete;
import net.gestion.pgm.domains.personnel.PersonnelModel;
import net.gestion.pgm.mappers.personnel.PersonnelMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonnelDAOImplement implements DAOTemplete<PersonnelModel>
{
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;

    DataSource ds ;
    
    public PersonnelDAOImplement(DataSource ds) {
		super();
		this.ds = ds;
        this.jdbcTemplate = new JdbcTemplate(ds);
		this.insert = new SimpleJdbcInsert(ds)
                .withTableName("personnel")
                .usingGeneratedKeyColumns("IDagent");
	}



    @Override
    public boolean delete(PersonnelModel obj) {
        return false;
    }

    @Override
    public boolean create(PersonnelModel obj) {
       try {
           Map<String, Object> params = new HashMap<>();
           params.put("actifornot", obj.getActifOrNot());
           params.put("adrssemp", obj.getAdressEmp());
           params.put("clerib", obj.getCleRib());
           params.put("dtesortie", obj.getDteSortie());
           params.put("nometprenom", obj.getNomPrenom());
           params.put("matricul", obj.getMatricule());
           params.put("nni", obj.getNni());
           params.put("codbank",obj.getCodeBank());
           params.put("bank",obj.getBank());
           params.put("datenaiss",obj.getDateNaiss());
           params.put("debucntrat",obj.getDebutCntrat());
           params.put("detacher",obj.getDetacher());
           params.put("dterecrutmnt",obj.getDteRecrutement());
           params.put("dtetitularisation",obj.getDteTitularisation());
           params.put("fincntrat",obj.getFinCntrat());
           params.put("lieunaiss",obj.getLieuNaiss());
           params.put("ministerorigne",obj.getMinisterOrigine());
           params.put("nometprenomarab",obj.getNomPrenomArab());
           params.put("numrocpte",obj.getNumroCpte());
           params.put("statusemp",obj.getStatusEmp());
           params.put("tlphone",obj.getTlphone());
           params.put("Typeeducation",obj.getTypeeducation());
           params.put("imgpers", obj.getImagPers());
           params.put("sexpers",obj.getSexePers());
           params.put("situationmatri", obj.getSituationMatri());
           params.put("autres", obj.getAutres());
           params.put("autres2", obj.getAutres2());
           params.put("corpsrecrt",obj.getCorpsRecrt());
           params.put("typef",obj.getTypeF());
           params.put("refrec",obj.getRefRec());
           params.put("fonctnref",obj.getFonctnRef());
           params.put("dateintegreatition", obj.getDateIntegration());
           params.put("saliareprestataire", obj.getSalairePrestataire());
           Number newId = insert.executeAndReturnKey(params);
           obj.setIdAgent(newId.intValue());
           return true;
       }catch (Exception e){
           e.printStackTrace();
           return false;
       }
    }
    @Override
    public boolean delete(int id) {
        String SQL = "delete from personnel where IDagent = ?";
        boolean b = jdbcTemplate.update(SQL, id) != 0;
        System.out.println("Deleted Record with ID = " + id );
        return b;
    }

    @Override
    public boolean update(PersonnelModel obj) {
        String SQL = "update  personnel set actifornot=?, adrssemp=?, clerib=?, dtesortie=?," +
                " nometprenom=?,matricul=?,nni=?," +
                " codbank=?, bank=?, datenaiss=?, " +
                "debucntrat=?, detacher=?, dterecrutmnt=?,dtetitularisation=?, " +
                "fincntrat=?, lieunaiss=?, ministerorigne=?, nometprenomarab=?, " +
                "numrocpte=?, statusemp=?, tlphone=?, Typeeducation=?,imgpers=?, sexepers=?, situationmatri=?,autres=?,autres2=?, corpsrecrt=?, typef=?, refrec=?, fonctnref=?, dateintegreatition=?, saliareprestataire=? where IDagent = ?";
        boolean b = jdbcTemplate.update(SQL, obj.getActifOrNot(),
                obj.getAdressEmp(), obj.getCleRib(),
                obj.getDteSortie(), obj.getNomPrenom(),
                obj.getMatricule(), obj.getNni(),
                obj.getCodeBank(),obj.getBank(),
                obj.getDateNaiss(), obj.getDebutCntrat(),
                obj.getDetacher(), obj.getDteRecrutement(),
                obj.getDteTitularisation(), obj.getFinCntrat(),
                obj.getLieuNaiss(), obj.getMinisterOrigine(),
                obj.getNomPrenomArab(), obj.getNumroCpte(),
                obj.getStatusEmp(), obj.getTlphone(),
                obj.getTypeeducation(),
                obj.getImagPers(), obj.getSexePers(),
                obj.getSituationMatri(),obj.getAutres(),
                obj.getAutres2(), obj.getCorpsRecrt(), obj.getTypeF(),
                obj.getRefRec(), obj.getFonctnRef(), obj.getDateIntegration(),
                obj.getSalairePrestataire(),
                obj.getIdAgent())!= 0;
        return b;
    }

    @Override
    public PersonnelModel find(int id) {
        String SQL = "select * from personnel where IDagent =?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new PersonnelMapper());
    }

    @Override
    public List<PersonnelModel> findAll() {
        String SQL = "select * from personnel";
        return jdbcTemplate.query(SQL,new PersonnelMapper());
    }

    public List<PersonnelModel> findByAffectation(int id) {
        String SQL = "select p.* from personnel p" +
                " inner join affectation aff on p.IDagent =aff.IDagent " +
                " where IDaffectation ="+id;
        return jdbcTemplate.query(SQL,new PersonnelMapper());
    }

    public List<PersonnelModel> findByLocalite(String localite) {
        String SQL = "select p.* from personnel p" +
                " right join affectation aff on p.IDagent=aff.IDagent" +
                " where aff.localite = '"+localite+"'";
        return jdbcTemplate.query(SQL, new PersonnelMapper());
    }

    public PersonnelModel findByMatricule(String matricule) {
        String SQL = "select * from personnel where matricul =?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{matricule}, new PersonnelMapper());
    }


}
