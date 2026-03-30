package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Prilog;
import me.student2026.model.Tiket;

import java.util.List;

@Dependent
public class TiketService {

    @Inject
    private EntityManager em;

    @Transactional
    public Tiket createTiket(Tiket tiket) throws ResourceNotFoundException {
        if (tiket == null) {
            throw new ResourceNotFoundException("Tiket nije proslijedjen");
        }
        if (tiket.getNaslov() == null || tiket.getNaslov().isEmpty()) {
            throw new ResourceNotFoundException("Naslov je prazan");
        }
        if (tiket.getOpis() == null || tiket.getOpis().isEmpty()) {
            throw new ResourceNotFoundException("Opis je prazan");
        }
        if (tiket.getRok() == null) {
            throw new ResourceNotFoundException("Rok nije proslijedjen");
        }
        return em.merge(tiket);
    }

    @Transactional
    public List<Tiket> getAllTiketi() throws ResourceNotFoundException {
        List<Tiket> tiketi = em.createQuery("from Tiket", Tiket.class).getResultList();
        if (tiketi.isEmpty()) {
            throw new ResourceNotFoundException("Nema tiketa.");
        }
        return tiketi;
    }

    public List<Tiket> getByNaslov(String naslov) {
        return em.createQuery("SELECT t FROM Tiket t WHERE t.naslov LIKE :naslov", Tiket.class)
                .setParameter("naslov", "%" + naslov + "%")
                .getResultList();
    }

    public Tiket getById(Long id) {
        Tiket tiket = em.find(Tiket.class, id);
        if (tiket == null) {
            throw new ResourceNotFoundException("Tiket sa id=" + id + " nije pronađen.");
        }
        return tiket;
    }

    public List<Prilog> getPrilozi(Long id) {
        Tiket tiket = em.find(Tiket.class, id);
        if (tiket == null) {
            throw new ResourceNotFoundException("Tiket sa id=" + id + " nije pronađen.");
        }
        return tiket.getPrilozi();
    }
}
