package net.gestion.pgrecrutement.services.personnel;


import net.gestion.pgrecrutement.common.InterfaceTemplete;
import net.gestion.pgrecrutement.dao.ConnectionDAO;
import net.gestion.pgrecrutement.daoImplement.personnel.DossierDAOImplement;
import net.gestion.pgrecrutement.domains.personnel.PersonnelDossierScanModel;
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
public class DossierService implements InterfaceTemplete<PersonnelDossierScanModel> {
    private final DossierDAOImplement dao=new DossierDAOImplement(ConnectionDAO.getInstance());

    @Override
    public boolean create(PersonnelDossierScanModel obj) {
        return dao.create(obj);
    }


    //faire la liste des images
    public boolean  create(List<MultipartFile> imageFile, PersonnelDossierScanModel obj) {
        try {
            for (MultipartFile imageDossier : imageFile) {
                obj.setImagFold(imageDossier.getBytes());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dao.create(obj);
    }

    @Override
    public boolean delete(PersonnelDossierScanModel obj) {
        if (obj.getIdDossierScan()!=0)
            return dao.delete((int) obj.getIdDossierScan());
        else return false;
    }

    public boolean delete(Integer id) {
        return this.dao.delete(id);
    }

    @Override
    public boolean update(PersonnelDossierScanModel obj) {
        if (obj!=null)
            return dao.update(obj);
        else return false;
    }

    @Override
    public PersonnelDossierScanModel find(int id) {
        return dao.find(id);
    }

    @Override
    public List<PersonnelDossierScanModel> findAll() {
        return dao.findAll();
    }

    public boolean update(Integer id, PersonnelDossierScanModel m) {
        PersonnelDossierScanModel model = find(id);
        if(model != null) {
        	model.setDateUpload(m.getDateUpload());
        	model.setIdDossierScan(m.getIdDossierScan());
        	model.setImagFold(m.getImagFold());
        	model.setLibelDossier(m.getLibelDossier());
        	model.setObservation(m.getObservation());
        	model.setPersonnel(m.getPersonnel());
            return this.update(model);
        }return false;
    }

    public List<PersonnelDossierScanModel> findByAgent(int IDagent) {
        return dao.findByAgent(IDagent);
    }

    /* public byte[] getImage(int id) throws DataFormatException, IOException {
        PersonnelDossierScanModel dbImage = this.find(id);
        return dbImage.getImagFold();
    }

     */
    public Map<String, Object> getImages(int id) throws DataFormatException, IOException {
        PersonnelDossierScanModel dbImage = this.find(id);
        HashMap<String, Object> mapImage = new HashMap<>();
        mapImage.put("imagfold", dbImage.getImagFold());
        return mapImage;
    }

}


