package mr.sigrh.sigremuneration.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "fonctionliste", schema = "general")
public class Fonctionliste {
    @Id
    @Column(name = "IDFONCTIONLISTE", nullable = false)
    private Long id;

    @Size(max = 500)
    @Column(name = "libfonctn", length = 500)
    private String libfonctn;

    @Size(max = 50)
    @Column(name = "libfonctnarab", length = 50)
    private String libfonctnarab;

    @Size(max = 500)
    @Column(name = "GRADE", length = 500)
    private String grade;

    @Size(max = 500)
    @Column(name = "ECHELLE", length = 500)
    private String echelle;

    @ColumnDefault("0")
    @Column(name = "salbase")
    private Double salbase;

    @Size(max = 500)
    @Column(name = "INDIXE", length = 500)
    private String indixe;

    @Size(max = 500)
    @Column(name = "echelon", length = 500)
    private String echelon;

}
