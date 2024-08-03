package mr.sigrh.sigremuneration.domaine;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "fonctionagent", schema = "general")
public class Fonctionagent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDFONCTIONAGENT", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "IDagent")
    private Personnel iDagent;

    @Size(max = 50)
    @Column(name = "fonctionlib", length = 50)
    private String fonctionlib;

    @Column(name = "datefonction")
    private LocalDate datefonction;

    @Size(max = 500)
    @Column(name = "ECHELLE", length = 500)
    private String echelle;

    @Size(max = 500)
    @Column(name = "echelon", length = 500)
    private String echelon;

    @Size(max = 500)
    @Column(name = "GroupeA", length = 500)
    private String groupeA;

    @Size(max = 500)
    @Column(name = "CAtegoriA", length = 500)
    private String cAtegoriA;

    @Size(max = 500)
    @Column(name = "CorpsA", length = 500)
    private String corpsA;

    @Size(max = 500)
    @Column(name = "GRADE", length = 500)
    private String grade;

    @Size(max = 500)
    @Column(name = "INDIXE", length = 500)
    private String indixe;

    @Size(max = 500)
    @Column(name = "CORPSAarab", length = 500)
    private String cORPSAarab;

    @Size(max = 50)
    @Column(name = "fonctionliarab", length = 50)
    private String fonctionliarab;

    @Column(name = "datedemand")
    private LocalDate datedemand;

    @Size(max = 500)
    @Column(name = "libeldemand", length = 500)
    private String libeldemand;

    @Size(max = 500)
    @Column(name = "libelavance", length = 500)
    private String libelavance;

}
