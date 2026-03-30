package me.student2026.scheduler;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import io.quarkus.scheduler.Scheduled;
import me.student2026.model.Stadijum;

import java.time.LocalDateTime;

@ApplicationScoped
public class TiketScheduler {

    @Inject
    EntityManager em;

    @Scheduled(cron="0 0 0 * * ?")
    @Transactional
    void proveriTikete() {
        Stadijum kasni = em.createQuery(
                "SELECT s FROM Stadijum s WHERE s.naziv = 'kasni'", Stadijum.class)
            .getResultStream().findFirst().orElse(null);

        if (kasni == null) {
            System.out.println("Stadijum 'kasni' nije pronađen.");
            return;
        }

        int count = em.createQuery(
                "UPDATE Tiket t SET t.stadijum = :kasni WHERE t.rok < :sada AND t.stadijum <> :kasni")
            .setParameter("kasni", kasni)
            .setParameter("sada", LocalDateTime.now())
            .executeUpdate();

        System.out.println("Tiketi prebačeni u status 'kasni': " + count);
    }
}