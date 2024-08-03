package mr.sigrh.sigsanctionsrecompenses.domaine;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "personnel", schema = "general")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDagent", nullable = false)
    private Long id;

    @Size(max = 500)
    @Column(name = "matricul", length = 500)
    private String matricul;

    @Column(name = "dtetitularisation")
    private LocalDate dtetitularisation;

    @Column(name = "dtesortie")
    private LocalDate dtesortie;

    @Size(max = 50)
    @Column(name = "statusemp", length = 50)
    private String statusemp;

    @Size(max = 500)
    @Column(name = "tlphone", length = 500)
    private String tlphone;

    @Size(max = 1000)
    @Column(name = "adrssemp", length = 1000)
    private String adrssemp;

    @Column(name = "debucntrat")
    private LocalDate debucntrat;

    @Column(name = "fincntrat")
    private LocalDate fincntrat;

    @Size(max = 1000)
    @Column(name = "nometprenom", length = 1000)
    private String nometprenom;

    @Column(name = "datenaiss")
    private LocalDate datenaiss;

    @Column(name = "actifornot")
    private Boolean actifornot;

    @Size(max = 50)
    @Column(name = "nni", length = 50)
    private String nni;

    @Size(max = 500)
    @Column(name = "bank", length = 500)
    private String bank;

    @Size(max = 50)
    @Column(name = "numrocpte", length = 50)
    private String numrocpte;

    @Size(max = 50)
    @Column(name = "lieunaiss", length = 50)
    private String lieunaiss;

    @Size(max = 500)
    @Column(name = "Typeeducation", length = 500)
    private String typeeducation;

    @Column(name = "dterecrutmnt")
    private LocalDate dterecrutmnt;

    @Size(max = 255)
    @Column(name = "detacher")
    private String detacher;

    @Size(max = 500)
    @Column(name = "ministerorigne", length = 500)
    private String ministerorigne;

    @Size(max = 50)
    @Column(name = "clerib", length = 50)
    private String clerib;

    @Size(max = 50)
    @Column(name = "codbank", length = 50)
    private String codbank;

    @Size(max = 500)
    @Column(name = "nometprenomarab", length = 500)
    private String nometprenomarab;

    @Column(name = "imgpers")
    private byte[] imgpers;

    @Size(max = 500)
    @Column(name = "sexepers", length = 500)
    private String sexepers;

    @Size(max = 500)
    @Column(name = "situationmatri", length = 500)
    private String situationmatri;

    @Size(max = 45)
    @Column(name = "autres", length = 45)
    private String autres;

    @Size(max = 45)
    @Column(name = "autres2", length = 45)
    private String autres2;

    @Size(max = 500)
    @Column(name = "corpsrecrt", length = 500)
    private String corpsrecrt;

    @Size(max = 500)
    @Column(name = "typef", length = 500)
    private String typef;

    @Size(max = 500)
    @Column(name = "refrec", length = 500)
    private String refrec;

    @Size(max = 500)
    @Column(name = "fonctnref", length = 500)
    private String fonctnref;

    @Column(name = "dateintegreatition")
    private LocalDate dateintegreatition;

    @Column(name = "saliareprestataire")
    private Float saliareprestataire;

}
