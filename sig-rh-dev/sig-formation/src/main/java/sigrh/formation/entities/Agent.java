package sigrh.formation.entities;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="agent")
public class Agent implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAgent;
	private String matricule;
    private String nom;
    private String prenom;
    private String sexe;
    private Date dateNaissance;
    private String diplomeAcademique;
    private String diplomeProfessionel;
    @ManyToOne
    @JoinColumn(name = "theme", referencedColumnName = "idTheme")
    private Theme theme;
    @JoinColumn(name = "ecole", referencedColumnName = "idEcole")
    @ManyToOne
    private Ecole ecole;

}
