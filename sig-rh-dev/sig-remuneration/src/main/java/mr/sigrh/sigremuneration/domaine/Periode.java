package mr.sigrh.sigremuneration.domaine;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Periode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date_debut")
    LocalDate dateDebut;
    @Column(name = "date_fin")
    LocalDate dateFin;
    Boolean actif;
}
