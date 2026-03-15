package me.student2026.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.model.Stadijum;

import java.util.List;

@ApplicationScoped
public class StadijumService {

    @Inject
    EntityManager em;

    @Transactional
    public Stadijum createStadijum(Stadijum stadijum) {
        return em.merge(stadijum);
    }

    public List<Stadijum> getAllStadijumi() {
        return em.createQuery("from Stadijum", Stadijum.class).getResultList();
    }
}