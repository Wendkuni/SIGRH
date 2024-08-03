package mr.sigrh.sigsanctionsrecompenses.service;

import mr.sigrh.sigsanctionsrecompenses.dto.SanctionDto;

import java.util.List;

public interface SanctionService extends AbstractService<SanctionDto>{
    List<SanctionDto> findByDeleted(boolean deleted);
    List<SanctionDto> findByType(String type);
}
