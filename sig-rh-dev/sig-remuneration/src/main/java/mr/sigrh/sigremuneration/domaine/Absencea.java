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
@Table(name = "absencea", schema = "general")
public class Absencea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDABSENCEA", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "IDagent")
    private Personnel iDagent;

    @Size(max = 500)
    @Column(name = "libelleab", length = 500)
    private String libelleab;

    @Column(name = "dateeffet")
    private LocalDate dateeffet;

    @Size(max = 50)
    @Column(name = "motif", length = 50)
    private String motif;

    @ColumnDefault("0")
    @Column(name = "nombrejr")
    private Integer nombrejr;

    @Size(max = 500)
    @Column(name = "signataire", length = 500)
    private String signataire;

    @Size(max = 500)
    @Column(name = "autorisation", length = 500)
    private String autorisation;

}
