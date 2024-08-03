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
@Table(name = "renumerationagent", schema = "general")
public class Renumerationagent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDRENUMERATIONAGENT", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @ColumnDefault("0")
    @JoinColumn(name = "IDagent")
    private Personnel iDagent;

    @ColumnDefault("0")
    @Column(name = "valmnt")
    private Double valmnt;

    @Size(max = 500)
    @Column(name = "banklib", length = 500)
    private String banklib;

    @Column(name = "dateeffet")
    private LocalDate dateeffet;

    @Size(max = 500)
    @Column(name = "codebank", length = 500)
    private String codebank;

}
