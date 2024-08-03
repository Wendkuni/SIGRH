package mr.sigrh.sigremuneration.services;

import mr.sigrh.sigremuneration.domaine.Periode;

public interface PeriodeService extends AbstractService<Periode> {
    Periode findActivePeriode(Boolean actif);
}
