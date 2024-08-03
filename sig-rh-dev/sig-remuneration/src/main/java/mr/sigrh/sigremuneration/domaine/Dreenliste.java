package mr.sigrh.sigremuneration.domaine;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dreenliste", schema = "general")
public class Dreenliste {
    @Id
    @Column(name = "idnewdreen", nullable = false)
    private Integer id;

    @Size(max = 500)
    @Column(name = "libeldren", length = 500)
    private String libeldren;

}
