package com.sigrh.gestionressourceh.services.personnel;

import com.sigrh.gestionressourceh.common.InterfaceTemplete;
import com.sigrh.gestionressourceh.dao.ConnectionDAO;
import com.sigrh.gestionressourceh.daoImplement.personnel.AffectationDAOImplement;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelAffectationModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelDossierScanModel;
import com.sigrh.gestionressourceh.domains.personnel.PersonnelModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
@Transactional
public class AffectationService implements InterfaceTemplete<PersonnelAffectationModel> {
    private final AffectationDAOImplement dao= new AffectationDAOImplement(ConnectionDAO.getInstance());

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

            return this.update(model);
        }return false;
    }

    public boolean create(MultipartFile imageDossier, MultipartFile imageSanitaire,PersonnelAffectationModel obj) throws IOException {
        obj.setImgDos(imageDossier.getBytes());
        obj.setImgSanit(imageSanitaire.getBytes());
        return this.dao.create(obj);
    }

    public Map<String,Object> getImage(int id) throws DataFormatException, IOException {
        PersonnelAffectationModel dbImage = this.find(id);
        HashMap<String, Object> mapImage = new HashMap<>();
        mapImage.put("imgDos",dbImage.getImgDos());
        mapImage.put("imgSanit",dbImage.getImgSanit());
        return mapImage;
    }

}
