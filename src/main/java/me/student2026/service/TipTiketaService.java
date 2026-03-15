package me.student2026.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.model.TipTiketa;

import java.util.List;

@ApplicationScoped
public class TipTiketaService {

    @Inject
    EntityManager em;

    @Transactional
    public TipTiketa createTipTiketa(TipTiketa tipTiketa) {
        return em.merge(tipTiketa);
    }

    public List<TipTiketa> getAllTipoviTiketa() {
        return em.createQuery("from TipTiketa", TipTiketa.class).getResultList();
    }
}