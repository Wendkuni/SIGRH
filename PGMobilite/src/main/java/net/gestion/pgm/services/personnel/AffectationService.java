package net.gestion.pgm.services.personnel;


import net.gestion.pgm.common.InterfaceTemplete;
import net.gestion.pgm.common.constant.TypeAffectation;
import net.gestion.pgm.common.constant.TypeNature;
import net.gestion.pgm.dao.ConnectionDAO;
import net.gestion.pgm.daoImplement.personnel.AffectationDAOImplement;
import net.gestion.pgm.domains.personnel.CritereAffectation;
import net.gestion.pgm.domains.personnel.PersonnelAffectationModel;
import net.gestion.pgm.domains.personnel.PersonnelDossierScanModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    @Override
    public boolean create(PersonnelAffectationModel obj) {
        return dao.create(obj);
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

    public boolean update(Integer id, PersonnelAffectationModel m) {
        PersonnelAffectationModel model = find(id);
        if(model != null) {
            model.setPersonnel(m.getPersonnel());
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
            return this.update(model);
        }return false;
    }

    public boolean create(List<MultipartFile> imageDossiers,PersonnelAffectationModel obj) throws IOException {
        if (this.dao.create(obj)&&!imageDossiers.isEmpty()) {
            try {
                for (MultipartFile file : imageDossiers) {
                    PersonnelDossierScanModel dossier = PersonnelDossierScanModel.builder()
                            .libelDossier(file.getOriginalFilename())
                            .personnel(obj.getPersonnel())
                           // .refsAffectation(dao.findAll().size())
                            .refsAffectation(obj.getIdAffectation())
                            .imagFold(file.getBytes())
                            .dateUpload(LocalDate.now())
                            .observation("dossier d'affectation")
                            .build();
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

    public Map<String,Object> getImage(int id) throws DataFormatException, IOException {
        PersonnelAffectationModel dbImage = this.find(id);
        HashMap<String, Object> mapImage = new HashMap<>();
        mapImage.put("imgDos",dbImage.getImgDos());
        mapImage.put("imgSanit",dbImage.getImgSanit());
        return mapImage;
    }


    public boolean estEligiblePourPermutation(PersonnelAffectationModel affectation) {
        if (affectation.getAncieneteGen()>3) {
            return true;
        }
        return false;
    }


    public float calculerPonderationC(PersonnelAffectationModel affectation) {
        float points = 0;

        // Ancieneté Poste prevoir une exception: si la condition n'est pas respecter,
        if (affectation.getAncienetePoste() != null && affectation.getAncienetePoste() >= 4) {
            points += (affectation.getAncienetePoste() - 3) * 0.5;
        }
//
        // Ancieneté willaya : revu
        if (affectation.getAncieneteGen() != null) {
            if (affectation.getAncieneteGen() >= 15) {
                points += 15;
            } else {
                points += affectation.getAncieneteGen();
            }
        }



        // Note Pédagogique
        points += affectation.getNotePedagogiq();

        // Moyenne des trois dernières notes administratives: revu
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

        // Sexe VCERIFIER LE FORMAT DE CASSE (revu)
        if (affectation.getPersonnel() != null && "FEMININ".equalsIgnoreCase(affectation.getPersonnel().getSexePers())) {
            points += 5;
        }

        // Situation Sanitaire
        if (affectation.getSituationSanit() != null) {
            points += 10;
        }

        // Regroupement Conjoint: revu
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

        // Ancieneté willaya : revu
        if (affectation.getAncieneteGen() != null) {
            if (affectation.getAncieneteGen() >= 15) {
                points += 15;
            } else {
                points += affectation.getAncieneteGen();
            }
        }

        // Ancieneté Scolaire
       /* if (affectation.getAncieneteGen() != null && affectation.getAncieneteGen() >= 15) {
            points += affectation.getAncieneteGen() - 15;
        }

        */

        // Ancieneté Poste
        if (affectation.getAncienetePoste() != null && affectation.getAncienetePoste() >= 4) {
            points += (affectation.getAncienetePoste() - 3) * 0.5;
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
        if (affectation.getPersonnel() != null && "FEMININ".equalsIgnoreCase(affectation.getPersonnel().getSexePers())) {
            points += 5;
        }
/*
REVOIR LA PERMUTATION: SI IL N'Y A PAS TROIS ANS
*/

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
