package mr.sigrh.sigsanctionsrecompenses.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mr.sigrh.sigsanctionsrecompenses.domaine.Personnel;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class PersonnelDto {
    private Long id;
    private String matricul;
    private LocalDate dtetitularisation;
    private LocalDate dtesortie;
    private String statusemp;
    private String tlphone;
    private String adrssemp;
    private LocalDate debucntrat;
    private LocalDate fincntrat;
    private String nometprenom;
    private LocalDate datenaiss;
    private Boolean actifornot;
    private String nni;
    private String bank;
    private String numrocpte;
    private String lieunaiss;
    private String typeeducation;
    private LocalDate dterecrutmnt;
    private String detacher;
    private String ministerorigne;
    private String clerib;
    private String codbank;
    private String nometprenomarab;
    private byte[] imgpers;
    private String sexepers;
    private String situationmatri;
    private String autres;
    private String autres2;
    private String corpsrecrt;
    private String typef;
    private String refrec;
    private String fonctnref;
    private LocalDate dateintegreatition;
    private Float saliareprestataire;

    // Conversion from Personnel to PersonnelDTO
    public static PersonnelDto fromPersonnel(Personnel personnel) {
        PersonnelDto dto = new PersonnelDto();
        dto.setId(personnel.getId());
        dto.setMatricul(personnel.getMatricul());
        dto.setDtetitularisation(personnel.getDtetitularisation());
        dto.setDtesortie(personnel.getDtesortie());
        dto.setStatusemp(personnel.getStatusemp());
        dto.setTlphone(personnel.getTlphone());
        dto.setAdrssemp(personnel.getAdrssemp());
        dto.setDebucntrat(personnel.getDebucntrat());
        dto.setFincntrat(personnel.getFincntrat());
        dto.setNometprenom(personnel.getNometprenom());
        dto.setDatenaiss(personnel.getDatenaiss());
        dto.setActifornot(personnel.getActifornot());
        dto.setNni(personnel.getNni());
        dto.setBank(personnel.getBank());
        dto.setNumrocpte(personnel.getNumrocpte());
        dto.setLieunaiss(personnel.getLieunaiss());
        dto.setTypeeducation(personnel.getTypeeducation());
        dto.setDterecrutmnt(personnel.getDterecrutmnt());
        dto.setDetacher(personnel.getDetacher());
        dto.setMinisterorigne(personnel.getMinisterorigne());
        dto.setClerib(personnel.getClerib());
        dto.setCodbank(personnel.getCodbank());
        dto.setNometprenomarab(personnel.getNometprenomarab());
        dto.setImgpers(personnel.getImgpers());
        dto.setSexepers(personnel.getSexepers());
        dto.setSituationmatri(personnel.getSituationmatri());
        dto.setAutres(personnel.getAutres());
        dto.setAutres2(personnel.getAutres2());
        dto.setCorpsrecrt(personnel.getCorpsrecrt());
        dto.setTypef(personnel.getTypef());
        dto.setRefrec(personnel.getRefrec());
        dto.setFonctnref(personnel.getFonctnref());
        dto.setDateintegreatition(personnel.getDateintegreatition());
        dto.setSaliareprestataire(personnel.getSaliareprestataire());
        return dto;
    }

    // Conversion from PersonnelDTO to Personnel
    public Personnel toPersonnel() {
        Personnel personnel = new Personnel();
        personnel.setId(this.getId());
        personnel.setMatricul(this.getMatricul());
        personnel.setDtetitularisation(this.getDtetitularisation());
        personnel.setDtesortie(this.getDtesortie());
        personnel.setStatusemp(this.getStatusemp());
        personnel.setTlphone(this.getTlphone());
        personnel.setAdrssemp(this.getAdrssemp());
        personnel.setDebucntrat(this.getDebucntrat());
        personnel.setFincntrat(this.getFincntrat());
        personnel.setNometprenom(this.getNometprenom());
        personnel.setDatenaiss(this.getDatenaiss());
        personnel.setActifornot(this.getActifornot());
        personnel.setNni(this.getNni());
        personnel.setBank(this.getBank());
        personnel.setNumrocpte(this.getNumrocpte());
        personnel.setLieunaiss(this.getLieunaiss());
        personnel.setTypeeducation(this.getTypeeducation());
        personnel.setDterecrutmnt(this.getDterecrutmnt());
        personnel.setDetacher(this.getDetacher());
        personnel.setMinisterorigne(this.getMinisterorigne());
        personnel.setClerib(this.getClerib());
        personnel.setCodbank(this.getCodbank());
        personnel.setNometprenomarab(this.getNometprenomarab());
        personnel.setImgpers(this.getImgpers());
        personnel.setSexepers(this.getSexepers());
        personnel.setSituationmatri(this.getSituationmatri());
        personnel.setAutres(this.getAutres());
        personnel.setAutres2(this.getAutres2());
        personnel.setCorpsrecrt(this.getCorpsrecrt());
        personnel.setTypef(this.getTypef());
        personnel.setRefrec(this.getRefrec());
        personnel.setFonctnref(this.getFonctnref());
        personnel.setDateintegreatition(this.getDateintegreatition());
        personnel.setSaliareprestataire(this.getSaliareprestataire());
        return personnel;
    }
}
