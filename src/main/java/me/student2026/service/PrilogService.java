package me.student2026.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.model.Prilog;

import java.util.List;

@ApplicationScoped
public class PrilogService {

    @Inject
    EntityManager em;

    @Transactional
    public Prilog createPrilog(Prilog prilog) {
        return em.merge(prilog);
    }

    public List<Prilog> getAllPrilozi() {
        return em.createQuery("from Prilog", Prilog.class).getResultList();
    }

}