package mr.sigrh.sigsanctionsrecompenses.service.serviceImpl;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import mr.sigrh.sigsanctionsrecompenses.domaine.Sanction;
import mr.sigrh.sigsanctionsrecompenses.dto.SanctionDto;
import mr.sigrh.sigsanctionsrecompenses.repositories.SanctionRepository;
import mr.sigrh.sigsanctionsrecompenses.service.SanctionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SanctionServiceImpl implements SanctionService {

    private final SanctionRepository sanctionRepository;
    @Override
    public Long save(SanctionDto dto) {
        Sanction sanction = SanctionDto.toEntity(dto);
        return sanctionRepository.save(sanction).getId();
    }

    @Override
    public List<SanctionDto> findAll() {
        return sanctionRepository.findAll().stream().map(SanctionDto::fromEntity).toList();
    }

    @Override
    public SanctionDto findById(Long id) {
        return sanctionRepository.findById(id).map(SanctionDto::fromEntity).orElse(null);
    }

    @Override
    public void deleteById(SanctionDto dto) {
        Sanction sanction = SanctionDto.toEntity(dto);
        sanction.setDeleted(true);
        sanctionRepository.save(sanction);
    }

    @Override
    public List<SanctionDto> findByDeleted(boolean deleted) {
        return sanctionRepository.findByDeleted(deleted).stream().map(SanctionDto::fromEntity).toList();
    }

    @Override
    public List<SanctionDto> findByType(String type) {
        return sanctionRepository.findByType(type).stream().map(SanctionDto::fromEntity).toList();
    }
}
