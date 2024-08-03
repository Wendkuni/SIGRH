package mr.sigrh.sigsanctionsrecompenses.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import mr.sigrh.sigsanctionsrecompenses.domaine.Sanction;

@Getter
@Setter
@Builder
public class SanctionDto {

    Long id;
    @NotBlank(message = "labelle est requis")
    String labelle;
    @NotBlank(message = "nom est requis")
    String type;
    @NotBlank(message = "nom est requis")
    String duree;
    boolean deleted = false;

    public static SanctionDto fromEntity(Sanction sanction) {
        return SanctionDto.builder()
                .id(sanction.getId())
                .labelle(sanction.getLabelle())
                .type(sanction.getType())
                .duree(sanction.getDuree())
                .deleted(sanction.isDeleted())
                .build();
    }

    public static Sanction toEntity(SanctionDto dto) {
        return Sanction.builder()
                .id(dto.getId())
                .labelle(dto.getLabelle())
                .type(dto.getType())
                .duree(dto.getDuree())
                .deleted(dto.isDeleted())
                .build();
    }


}
