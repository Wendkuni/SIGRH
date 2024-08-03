package sigrh.formation.entities;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="stagiaire")
public class Stagiaire implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStagiaire;
	private String nn;
	private String nom;
	private String prenom;
	private String sexe;
	//@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateNaissance;
	private String anneeAcademique;
	private String niveau;
	private String resultat;
	private Boolean status;
	@ManyToOne
	@JoinColumn(name = "ecole", referencedColumnName = "idEcole") 
	private Ecole ecole;	 
	@ManyToOne
	@JoinColumn(name = "filiere", referencedColumnName = "idFiliere")
    Filiere filiere;
}


