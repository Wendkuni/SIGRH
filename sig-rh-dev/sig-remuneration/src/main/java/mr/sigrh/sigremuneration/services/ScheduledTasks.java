package mr.sigrh.sigremuneration.services;

import lombok.RequiredArgsConstructor;
import mr.sigrh.sigremuneration.domaine.Periode;
import mr.sigrh.sigremuneration.repositories.PeriodeRepository; // Assurez-vous d'importer votre repository
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private final PeriodeRepository periodeRepository;

    @Scheduled(cron = "0 0 * * * ?")  // Exemple : toutes les 1 minutes
    public void performTask() {
        List<Periode> periodes = periodeRepository.findAll();
        for (Periode periode : periodes) {
            periode.setActif(false);
            periodeRepository.save(periode);
        }
        Periode periode = new Periode();
        periode.setDateDebut(this.getFirstDayOfCurrentMonth());
        periode.setDateFin(this.getLastDayOfCurrentMonth());
        periode.setActif(true);
        periodeRepository.save(periode);
        System.out.println("Tâche périodique exécutée à " + System.currentTimeMillis());
        // Votre logique ici
    }

    public LocalDate getFirstDayOfCurrentMonth() {
        YearMonth currentMonth = YearMonth.now();
        return currentMonth.atDay(1);
    }

    public LocalDate getLastDayOfCurrentMonth() {
        YearMonth currentMonth = YearMonth.now();
        return currentMonth.atEndOfMonth();
    }
}
