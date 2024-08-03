package sigrh.formation.entities;

import jakarta.annotation.Generated;
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
import sigrh.formation.dto.EcoleDTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="theme")
public class Theme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTheme;
	private String code;
	private String intitule;
	private String modalite;
	private String dureeFormation;
	private String lieuFormation;
	private String financement;
	@ManyToOne
	@JoinColumn(name = "ecole", referencedColumnName = "idEcole")
	private Ecole ecole;
}
