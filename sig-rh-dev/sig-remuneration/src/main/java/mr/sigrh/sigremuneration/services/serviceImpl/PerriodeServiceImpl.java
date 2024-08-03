package mr.sigrh.sigremuneration.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import mr.sigrh.sigremuneration.domaine.Periode;
import mr.sigrh.sigremuneration.repositories.PeriodeRepository;
import mr.sigrh.sigremuneration.services.PeriodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PerriodeServiceImpl implements PeriodeService {

    private final PeriodeRepository periodeRepository;
    @Override
    public Long save(Periode dto) {
        return periodeRepository.save(dto).getId();
    }

    @Override
    public List<Periode> findAll() {
        return periodeRepository.findAll();
    }

    @Override
    public Periode findById(Long id) {
        return periodeRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Periode findActivePeriode(Boolean actif) {
        return periodeRepository.findByActif(actif);
    }
}
