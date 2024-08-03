package sigrh.formation.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InscriptionDTO {
	
	private Integer idInscription;
    private String dren;
    private String nni;
    private String matricule;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String sexe;
    private String diplomeAcademique;
    private String diplomeProfessionnel;
    private String posteActuel;
    private String fonctionActuelle;
    private Boolean isValideDren;
    private Boolean isValideNational;
    private String motifDren;
    private String motifNational;
    private String typeFormation;
    private String typeEtablissement;
    private String filename;

}
