package net.gestion.pgm.services.personnel;


import net.gestion.pgm.common.InterfaceTemplete;
import net.gestion.pgm.dao.ConnectionDAO;
import net.gestion.pgm.daoImplement.personnel.AffectationDAOImplement;
import net.gestion.pgm.domains.personnel.PersonnelAffectationModel;
import net.gestion.pgm.domains.personnel.PersonnelDossierScanModel;
import net.gestion.pgm.domains.personnel.PersonnelFonctionModel;
import net.gestion.pgm.domains.personnel.PersonnelModel;
import net.gestion.pgm.services.dtos.personnel.AffectationDTO;
import net.gestion.pgm.services.dtos.personnel.DossierDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
@Transactional
public class  AffectationService implements InterfaceTemplete<PersonnelAffectationModel> {
    private final AffectationDAOImplement dao= new AffectationDAOImplement(ConnectionDAO.getInstance());
    private DossierService dossierService;

    private PersonnelService service;

    private FonctionAgentService fonctionAgentservice;
    @Override
    public boolean create(PersonnelAffectationModel obj) {
            return dao.create(obj);
    }

    public boolean createPermutatation(List<MultipartFile> imageDossiers, PersonnelAffectationModel obj, String matricule) throws IOException {

        if (verifierAnciennete(obj.getAgent())) {
            PersonnelModel agent2 = new PersonnelService().findByMatricul(matricule);
            PersonnelModel agent1 = obj.getAgent();
            PersonnelFonctionModel fonctionagent1= new FonctionAgentService().findByAgent((int) agent1.getIdAgent());
            PersonnelFonctionModel fonctionagent2= new FonctionAgentService().findByAgent(((int)agent2.getIdAgent()));

            if(verifierGradeCorpsFonction(fonctionagent1,fonctionagent2)){
                obj.setAgent2(agent2);
                if (this.dao.create(obj)&&!imageDossiers.isEmpty()){
                   try{
                       for (MultipartFile file : imageDossiers) {
                           PersonnelDossierScanModel dossier=new PersonnelDossierScanModel();
                           dossier.setObservation("dossier d'affectation Num"+obj.getIdAffectation());
                           dossier.setPersonnel(obj.getAgent());
                           dossier.setRefsAffectation(obj.getIdAffectation());
                           dossier.setDateUpload(LocalDate.now());
                           dossier.setLibelDossier(file.getOriginalFilename());
                           dossier.setImagFold(file.getBytes());
                           dossierService.create(dossier);
                       }
                       return this.create(obj);

                   }catch (Exception e){
                       e.printStackTrace();
                       return false;
                   }
                }

            }
            return false;
        }

        return false;

    }

    public boolean verifierAnciennete(PersonnelModel agent) {
        LocalDate dateRecrutement = agent.getDteRecrutement();
        return dateRecrutement != null && dateRecrutement.isBefore(LocalDate.now().minusYears(3));
    }

    public boolean verifierGradeCorpsFonction(PersonnelFonctionModel fonctionAgent1, PersonnelFonctionModel fonctionAgent2) {
        return fonctionAgent1.getGrade().equals(fonctionAgent2.getGrade()) &&
                fonctionAgent1.getCorps().equals(fonctionAgent2.getCorps()) &&
                fonctionAgent1.getLibelleFonction().equals(fonctionAgent2.getLibelleFonctionArab());
    }




    public boolean initierPermutation(PersonnelAffectationModel affectation) {
        PersonnelModel agent1 = affectation.getAgent();
        if (!verifierAnciennete(agent1)) {
            return false; // Ancienneté insuffisante pour agent1
        }
        dao.create(affectation);
        return true;
    }

    @Override
    public boolean delete(PersonnelAffectationModel obj) {
        if (obj.getIdAffectation()!=null)
        return dao.delete(obj.getIdAffectation().intValue());
        else return false;
    }
    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    @Override
    public boolean update(PersonnelAffectationModel obj) {
        if (obj!=null)
        return dao.update(obj);
        else return false;
    }

    @Override
    public PersonnelAffectationModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelAffectationModel> findAll() {
        return dao.findAll();
    }

    public List<PersonnelAffectationModel> findByAgent(int IDagent) {
        return dao.findByAgent(IDagent);
    }

    public boolean update(Integer id, AffectationDTO m) {
        PersonnelAffectationModel model = new AffectationDTO().toAffectationModel(m);

        model = find(id);
        if(model != null) {

            model.setAgent(m.getAgent());
            model.setLocalite(m.getLocalite());
            model.setServiceEcole(m.getServiceEcole());
            model.setDateEffet(m.getDateEffet());
            model.setDren(m.getDren());
            model.setNotePedagogiq(m.getNotePedagogiq());
            model.setNature(m.getNature());
            model.setMotif(m.getMotif());
            model.setSituationSanit(m.getSituationSanit());
            model.setImgSanit(m.getImgSanit());
            model.setLibelDos(m.getLibelDos());
            model.setImgDos(m.getImgDos());
            model.setNombreFant(m.getNombreFant());
            model.setAncieneteGen(m.getAncieneteGen());
            model.setAncienetePoste(m.getAncienetePoste());
            model.setPosteOrigin(m.getPosteOrigin());
            model.setPosteDestinat1(m.getPosteDestinat1());
            model.setPosteDestinat2(m.getPosteDestinat2());
            model.setPosteDestinat3(m.getPosteDestinat3());
            model.setPosteDestinat4(m.getPosteDestinat4());
            model.setPosteDestinat5(m.getPosteDestinat5());
            model.setDistinction(m.getDistinction());
            model.setRegroupementConjoint(m.getRegroupementConjoint());
            model.setAutresSocial(m.getAutresSocial());
            model.setNoteAdministrative(m.getNoteAdministrative());
            model.setSituationMatrimo(m.getSituationMatrimo());
            model.setEtatAffect(m.getEtatAffect());
            model.setPointsPondere(m.getPointsPondere());
            model.setAutresDiplome(m.getAutresDiplome());
            model.setDateDemande(m.getDateDemande());
            model.setDestinationRetenue(m.getDestinationRetenue());
            model.setAppreciation(m.getAppreciation());
            if(this.update(model)){
                for (MultipartFile file : m.getDocuments()) {
                    PersonnelDossierScanModel dossier=new PersonnelDossierScanModel();
                    dossier.setObservation("dossier d'affectation Num"+m.getIdAffectation());
                    dossier.setPersonnel(m.getAgent());
                    dossier.setRefsAffectation(m.getIdAffectation());
                    dossier.setDateUpload(LocalDate.now());
                    dossier.setLibelDossier(file.getOriginalFilename());
                    try {
                        dossier.setImagFold(file.getBytes());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    dossierService.update(dossier);
                }
                return true;
            }
            else return false;


        }return false;
    }

    public boolean create(List<MultipartFile> imageDossiers,PersonnelAffectationModel obj) throws IOException {
       /* if (obj.getAgent() == null || !fonctionAgentservice.exists(obj.getAgent().getIdAgent())) {
            throw new IllegalArgumentException("L'agent n'existe pas.");
        }
        */
        if (this.dao.create(obj)&&!imageDossiers.isEmpty()) {

            try {
                for (MultipartFile file : imageDossiers) {
                    PersonnelDossierScanModel dossier=new PersonnelDossierScanModel();
                    dossier.setObservation("dossier d'affectation Num"+obj.getIdAffectation());
                    dossier.setPersonnel(obj.getAgent());
                    dossier.setRefsAffectation(obj.getIdAffectation());
                    dossier.setDateUpload(LocalDate.now());
                    dossier.setLibelDossier(file.getOriginalFilename());
                    dossier.setImagFold(file.getBytes());
                    dossierService.create(dossier);
                }
                return true;
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }


    public List<PersonnelDossierScanModel> getDossierAffectation(PersonnelAffectationModel obj) {
        return dao.getDossierByAffectation(obj);
    }


    public List<byte[]> getImages(PersonnelAffectationModel obj) {

        try {
            List<byte[]> content =new ArrayList<>();
            for (PersonnelDossierScanModel doss:this.getDossierAffectation(obj))
                content.add(doss.getImagFold());
            return content;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }





    public boolean estEligiblePourPermutation(PersonnelAffectationModel affectation) {
        if (affectation.getAncieneteGen()>3) {
            return true;
        }
        return false;
    }

    public float calculerPonderationC(PersonnelAffectationModel affectation) {
        float points = 0;

        // Ancieneté dans la fonction public
        if (affectation.getAncieneteGen() != null && affectation.getAncieneteGen() >= 4) {
            points += (affectation.getAncieneteGen() - 3) * 0.5;
        }

        // Ancieneté willaya
        if (affectation.getAncienetePoste() != null) {
            if (affectation.getAncienetePoste() >= 15) {
                points += 15;
            } else {
                points += affectation.getAncieneteGen();
            }
        }

        // Note Pédagogique
        points += affectation.getNotePedagogiq();

        // Moyenne des trois dernières notes administratives
        points += affectation.getNoteAdministrative();

        // Distinction
        if (affectation.getDistinction() != null) {
            switch (affectation.getDistinction()) {
                case NATIONALE:
                    points += 10;
                    break;
                case REGIONALE:
                    points += 8;
                    break;
                case DEPARTEMENTALE:
                    points += 5;
                    break;
            }
        }

        // Nombre d'enfants
        if (affectation.getNombreFant() != null) {
            if (affectation.getNombreFant() >= 5) {
                points += 10;
            } else {
                points += affectation.getNombreFant() * 2;
            }
        }

        // Mettre en stand by DREN
        switch (affectation.getDren()) {
            case "Nouakchott Nord":
            case "Nouakchott Ouest":
            case "Nouakchott Sud":
                points += 0;
                break;
            case "Trarza":
            case "Inchiri":
            case "D. Nouadhibou":
                points += 1;
                break;
            case "Brakna":
            case "Adrar":
            case "Tiris Zemour":
                points += 4;
                break;
            case "Gorgol":
            case "Assaba":
            case "Hodh Gharbi":
                points += 8;
                break;
            case "H. Charghi":
            case "Guidimakha":
            case "Tagant":
                points += 10;
                break;
        }

        // Sexe
        if (affectation.getAgent() != null && "FEMININ".equalsIgnoreCase(affectation.getAgent().getSexePers())) {
            points += 5;
        }

        // Situation Sanitaire
        if (affectation.getSituationSanit() != null) {
            points += 10;
        }

        // Regroupement Conjoint
        if (affectation.getRegroupementConjoint() != null) {
            points += 10;
        }

        // Autres Social
        if (affectation.getAutresSocial() != null) {
            points += 5;
        }

        affectation.setPointsPondere(points);
        return points;
    }

    public float calculerPonderationN(PersonnelAffectationModel affectation) {
        float points = 0;
// avoir une ancienneté générale de cinq ans au moins avant de faire une demande de nommination.

        // Ancieneté au poste
        if (affectation.getAncienetePoste() != null && affectation.getAncienetePoste()>5) {
            if (affectation.getAncienetePoste() >= 15) {
                points += 15;
            } else {
                points += affectation.getAncieneteGen();
            }
        }

        // Ancieneté dans l'administration Scolaire
       /* if (affectation.getAncieneteGen() != null && affectation.getAncieneteGen() >= 15) {
            points += affectation.getAncieneteGen() - 15;
        }

        */



        // Ancieneté dans la fonction public
        if (affectation.getAncieneteGen() != null && affectation.getAncieneteGen() >= 4) {
            points += (affectation.getAncieneteGen() - 3) * 0.5;
        }

        // Note Pédagogique
        points += affectation.getNotePedagogiq();

        // Moyenne des trois dernières notes administratives
        points += affectation.getNoteAdministrative() ;

        // Distinction
        if (affectation.getDistinction() != null) {
            switch (affectation.getDistinction()) {
                case NATIONALE:
                    points += 10;
                    break;
                case REGIONALE:
                    points += 8;
                    break;
                case DEPARTEMENTALE:
                    points += 5;
                    break;
            }
        }

        // Sexe
        if (affectation.getAgent() != null && "FEMININ".equalsIgnoreCase(affectation.getAgent().getSexePers())) {
            points += 5;
        }


        // Autres Diplomes
        if (affectation.getAutresDiplome() != null) {
            switch (affectation.getAutresDiplome()) {
                case "bac+5":
                    points += 10;
                    break;
                case "bac+3":
                    points += 8;
                    break;
                default:
                    points += 5;
                    break;
            }
        }

        affectation.setPointsPondere(points);
        return points;
    }


}
