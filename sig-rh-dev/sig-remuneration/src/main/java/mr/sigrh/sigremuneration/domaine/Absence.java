package mr.sigrh.sigremuneration.domaine;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_agent")
    private Personnel agent;

    @ManyToOne
    @JoinColumn(name = "id_periode")
    private Periode periode;

}
