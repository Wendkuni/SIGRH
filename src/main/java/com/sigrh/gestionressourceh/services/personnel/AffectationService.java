package com.sigrh.gestionressourceh.services.personnel;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.AffectationDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
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


}
