package me.student2026.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.model.Kriticnost;

import java.util.List;

@ApplicationScoped
public class KriticnostService {

    @Inject
    EntityManager em;

    @Transactional
    public Kriticnost createKriticnost(Kriticnost kriticnost) {
        return em.merge(kriticnost);
    }

    public List<Kriticnost> getAllKriticnosti() {
        return em.createQuery("from Kriticnost", Kriticnost.class).getResultList();
    }
}