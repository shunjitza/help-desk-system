package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Kriticnost;

import java.util.List;

@Dependent
public class KriticnostService {

    @Inject
    private EntityManager em;

    @Transactional
    public Kriticnost createKriticnost(Kriticnost kriticnost) throws ResourceNotFoundException {
        if (kriticnost == null) {
            throw new ResourceNotFoundException("Kriticnost nije proslijedjena");
        }
        if (kriticnost.getNaziv() == null || kriticnost.getNaziv().isEmpty()) {
            throw new ResourceNotFoundException("Naziv je prazan");
        }
        if (kriticnost.getOpis() == null || kriticnost.getOpis().isEmpty()) {
            throw new ResourceNotFoundException("Opis je prazan");
        }
        return em.merge(kriticnost);
    }

    @Transactional
    public List<Kriticnost> getAllKriticnosti() throws ResourceNotFoundException {
        List<Kriticnost> kriticnosti = em.createQuery("from Kriticnost", Kriticnost.class).getResultList();
        if (kriticnosti.isEmpty()) {
            throw new ResourceNotFoundException("Nema kriticnosti.");
        }
        return kriticnosti;
    }

    public List<Kriticnost> getByNaziv(String naziv) {
        return em.createQuery("SELECT k FROM Kriticnost k WHERE k.naziv LIKE :naziv", Kriticnost.class)
                .setParameter("naziv", "%" + naziv + "%")
                .getResultList();
    }

    public Kriticnost getById(Long id) {
        Kriticnost kriticnost = em.find(Kriticnost.class, id);
        if (kriticnost == null) {
            throw new ResourceNotFoundException("Kriticnost sa id=" + id + " nije pronađena.");
        }
        return kriticnost;
    }
}
