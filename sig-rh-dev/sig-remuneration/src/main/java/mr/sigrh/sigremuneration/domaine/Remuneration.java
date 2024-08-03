package mr.sigrh.sigremuneration.domaine;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "remuneration", schema = "general")
public class Remuneration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_renumeration", nullable = false)
    private Long id;

    @Size(max = 255)
    @Column(name = "code_bank")
    private String codeBank;

    @Column(name = "date_effet")
    private LocalDate dateEffet;

    @Size(max = 255)
    @Column(name = "libelle_bank")
    private String libelleBank;

    @Column(name = "valeur_montant")
    private Double valeurMontant;

}
