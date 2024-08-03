package mr.sigrh.sigsanctionsrecompenses.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mr.sigrh.sigsanctionsrecompenses.domaine.AgentSanction;
import mr.sigrh.sigsanctionsrecompenses.domaine.Personnel;
import mr.sigrh.sigsanctionsrecompenses.dto.AgentSanctionDto;
import mr.sigrh.sigsanctionsrecompenses.repositories.AgentSanctionRepository;
import mr.sigrh.sigsanctionsrecompenses.repositories.PersonnelRepository;
import mr.sigrh.sigsanctionsrecompenses.service.AgentSanctionService;
import mr.sigrh.sigsanctionsrecompenses.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgentSanctionServiceImpl implements AgentSanctionService {

    private final AgentSanctionRepository agentSanctionRepository;
    private final FileStorageService fileStorageService;
    private final PersonnelRepository personnelRepository;

    @Override
    @Transactional
    public Long save(AgentSanctionDto dto) {
        try {
            AgentSanction agentSanction = AgentSanctionDto.toEntity(dto);

            // Stocker chaque fichier et mettre à jour l'entité
            String demandeExplication = fileStorageService.storeFile(dto.getDemandeExplication());
            agentSanction.setDemandeExplication(demandeExplication);

            String reponseExplication = fileStorageService.storeFile(dto.getReponseExplication());
            agentSanction.setReponseExplication(reponseExplication);

            String rapportSuperieur = fileStorageService.storeFile(dto.getRapportSuperieur());
            agentSanction.setRapportSuperieur(rapportSuperieur);

            String pvConseilDiscipline = fileStorageService.storeFile(dto.getPvConseilDiscipline());
            agentSanction.setPvConseilDiscipline(pvConseilDiscipline);
            Personnel personnel = personnelRepository.findById(dto.getIdAgent()).orElse(null);
            agentSanction.setAgent(personnel);
            return agentSanctionRepository.save(agentSanction).getId();
        } catch (Exception e) {
            log.error("Erreur lors de la sauvegarde de la sanction : {}", e.getMessage(), e);
            throw new RuntimeException("Erreur lors de la sauvegarde de la sanction.", e);
        }

    }

    @Override
    public List<AgentSanctionDto> findAll() {
        agentSanctionRepository.findAll().forEach(agentSanction -> System.out.println("AgentSanction "+agentSanction.getDemandeExplication()));
        return agentSanctionRepository.findAll().stream()
                .map(AgentSanctionDto::fromEntity)
                .toList();
    }

    @Override
    public AgentSanctionDto findById(Long id) {
        Optional<AgentSanction> agentSanction = agentSanctionRepository.findById(id);
        return agentSanction.map(AgentSanctionDto::fromEntity).orElse(null);
    }

    @Override
    @Transactional
    public void deleteById(AgentSanctionDto dto) {
        try {
            Optional<AgentSanction> agentSanction = agentSanctionRepository.findById(dto.getId());
            if (agentSanction.isPresent()) {
                AgentSanction sanction = agentSanction.get();
                // Supprimer les fichiers associés
                fileStorageService.deleteFile(sanction.getDemandeExplication());
                fileStorageService.deleteFile(sanction.getReponseExplication());
                fileStorageService.deleteFile(sanction.getRapportSuperieur());
                fileStorageService.deleteFile(sanction.getPvConseilDiscipline());

                // Supprimer l'enregistrement de la base de données
                agentSanctionRepository.deleteById(dto.getId());
            } else {
                log.warn("Aucune sanction trouvée avec l'ID : {}", dto.getId());
            }
        } catch (Exception e) {
            log.error("Erreur lors de la suppression de la sanction : {}", e.getMessage());
            throw new RuntimeException("Erreur lors de la suppression de la sanction.", e);
        }
    }
}
