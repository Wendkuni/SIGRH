package mr.sigrh.sigsanctionsrecompenses.service;

import mr.sigrh.sigsanctionsrecompenses.domaine.Personnel;
import mr.sigrh.sigsanctionsrecompenses.dto.PersonnelDto;

import java.util.List;

public interface PersonnelService extends AbstractService<Personnel> {
    List<PersonnelDto> findByTypeF(String typeF);
}
