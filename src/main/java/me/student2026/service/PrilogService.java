package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Prilog;

import java.util.List;

@Dependent
public class PrilogService {

    @Inject
    private EntityManager em;

    @Transactional
    public Prilog createPrilog(Prilog prilog) throws ResourceNotFoundException {
        if (prilog == null) {
            throw new ResourceNotFoundException("Prilog nije proslijedjen");
        }
        if (prilog.getNazivFajla() == null || prilog.getNazivFajla().isEmpty()) {
            throw new ResourceNotFoundException("Naziv fajla je prazan");
        }
        if (prilog.getPutanja() == null || prilog.getPutanja().isEmpty()) {
            throw new ResourceNotFoundException("Putanja je prazna");
        }
        if (prilog.getTipFajla() == null || prilog.getTipFajla().isEmpty()) {
            throw new ResourceNotFoundException("Tip fajla je prazan");
        }
        return em.merge(prilog);
    }

    @Transactional
    public List<Prilog> getAllPrilozi() throws ResourceNotFoundException {
        List<Prilog> prilozi = em.createQuery("from Prilog", Prilog.class).getResultList();
        if (prilozi.isEmpty()) {
            throw new ResourceNotFoundException("Nema priloga.");
        }
        return prilozi;
    }

    public List<Prilog> getByNazivFajla(String nazivFajla) {
        return em.createQuery("SELECT p FROM Prilog p WHERE p.nazivFajla LIKE :nazivFajla", Prilog.class)
                .setParameter("nazivFajla", "%" + nazivFajla + "%")
                .getResultList();
    }

    public Prilog getById(Long id) {
        Prilog prilog = em.find(Prilog.class, id);
        if (prilog == null) {
            throw new ResourceNotFoundException("Prilog sa id=" + id + " nije pronađen.");
        }
        return prilog;
    }
}
