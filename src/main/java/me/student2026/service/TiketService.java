package me.student2026.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.model.Tiket;

import java.util.List;

@ApplicationScoped
public class TiketService {

    @Inject
    EntityManager em;

    @Transactional
    public Tiket createTiket(Tiket tiket) {
        return em.merge(tiket);
    }

    public List<Tiket> getAllTiketi() {
        return em.createQuery("from Tiket", Tiket.class).getResultList();
    }
}
