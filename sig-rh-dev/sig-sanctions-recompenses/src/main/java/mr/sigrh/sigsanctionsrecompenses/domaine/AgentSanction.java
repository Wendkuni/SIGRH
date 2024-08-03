package mr.sigrh.sigsanctionsrecompenses.domaine;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AgentSanction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean statut = false;

    @ManyToOne
    @JoinColumn(name = "id_agent")
    private Personnel agent;

    @ManyToOne
    @JoinColumn(name = "sanction_id")
    private Sanction sanction;

    private String demandeExplication;
    private String reponseExplication;
    private String rapportSuperieur;
    private String pvConseilDiscipline;
}
