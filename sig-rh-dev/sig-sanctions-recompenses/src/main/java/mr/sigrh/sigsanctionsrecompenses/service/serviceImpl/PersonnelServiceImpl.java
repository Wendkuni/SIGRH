package mr.sigrh.sigsanctionsrecompenses.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import mr.sigrh.sigsanctionsrecompenses.domaine.Personnel;
import mr.sigrh.sigsanctionsrecompenses.dto.PersonnelDto;
import mr.sigrh.sigsanctionsrecompenses.repositories.PersonnelRepository;
import mr.sigrh.sigsanctionsrecompenses.service.PersonnelService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PersonnelServiceImpl implements PersonnelService {

    private final PersonnelRepository personnelRepository;
    @Override
    public Long save(Personnel dto) {
        return 0L;
    }

    @Override
    public List<Personnel> findAll() {
        return List.of();
    }

    @Override
    public Personnel findById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Personnel dto) {

    }

    @Override
    public List<PersonnelDto> findByTypeF(String typeF) {
        return personnelRepository.findByTypef(typeF).stream().map(PersonnelDto::fromPersonnel).toList();
    }
}
