package sigrh.formation.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sigrh.formation.entities.Ecole;
import sigrh.formation.entities.Filiere;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StagiaireDTO {
	
	private Integer idStagiaire;
	private String nn;
	private String nom;
	private String prenom;
	private String sexe;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = DateDeserializer.class)
	private Date dateNaissance;
	private String anneeAcademique;
	private String niveau;
	private String resultat;
	private Boolean status;
	private Filiere filiere;
	private Ecole ecole;

}
