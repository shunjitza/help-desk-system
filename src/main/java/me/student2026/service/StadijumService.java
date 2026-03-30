package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Stadijum;

import java.util.List;

@Dependent
public class StadijumService {

    @Inject
    private EntityManager em;

    @Transactional
    public Stadijum createStadijum(Stadijum stadijum) throws ResourceNotFoundException {
        if (stadijum == null) {
            throw new ResourceNotFoundException("Stadijum nije proslijedjen");
        }
        if (stadijum.getNaziv() == null || stadijum.getNaziv().isEmpty()) {
            throw new ResourceNotFoundException("Naziv je prazan");
        }
        if (stadijum.getOpis() == null || stadijum.getOpis().isEmpty()) {
            throw new ResourceNotFoundException("Opis je prazan");
        }
        return em.merge(stadijum);
    }

    @Transactional
    public List<Stadijum> getAllStadijumi() throws ResourceNotFoundException {
        List<Stadijum> stadijumi = em.createQuery("from Stadijum", Stadijum.class).getResultList();
        if (stadijumi.isEmpty()) {
            throw new ResourceNotFoundException("Nema stadijuma.");
        }
        return stadijumi;
    }

    public List<Stadijum> getByNaziv(String naziv) {
        return em.createQuery("SELECT s FROM Stadijum s WHERE s.naziv LIKE :naziv", Stadijum.class)
                .setParameter("naziv", "%" + naziv + "%")
                .getResultList();
    }

    public Stadijum getById(Long id) {
        Stadijum stadijum = em.find(Stadijum.class, id);
        if (stadijum == null) {
            throw new ResourceNotFoundException("Stadijum sa id=" + id + " nije pronađen.");
        }
        return stadijum;
    }
}
