package sigrh.formation.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="inscription")
public class Inscription {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
