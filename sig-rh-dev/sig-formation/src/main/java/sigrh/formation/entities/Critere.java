package sigrh.formation.entities;

import java.util.Date;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "critere")
public class Critere {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCritere;
    private String texte;
    private String isValide;

}
