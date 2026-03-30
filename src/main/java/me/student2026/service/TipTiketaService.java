package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.TipTiketa;

import java.util.List;

@Dependent
public class TipTiketaService {

    @Inject
    private EntityManager em;

    @Transactional
    public TipTiketa createTipTiketa(TipTiketa tipTiketa) throws ResourceNotFoundException {
        if (tipTiketa == null) {
            throw new ResourceNotFoundException("TipTiketa nije proslijedjen");
        }
        if (tipTiketa.getNaziv() == null || tipTiketa.getNaziv().isEmpty()) {
            throw new ResourceNotFoundException("Naziv je prazan");
        }
        if (tipTiketa.getOpis() == null || tipTiketa.getOpis().isEmpty()) {
            throw new ResourceNotFoundException("Opis je prazan");
        }
        return em.merge(tipTiketa);
    }

    @Transactional
    public List<TipTiketa> getAllTipoviTiketa() throws ResourceNotFoundException {
        List<TipTiketa> tipoviTiketa = em.createQuery("from TipTiketa", TipTiketa.class).getResultList();
        if (tipoviTiketa.isEmpty()) {
            throw new ResourceNotFoundException("Nema tipova tiketa.");
        }
        return tipoviTiketa;
    }

    public List<TipTiketa> getByNaziv(String naziv) {
        return em.createQuery("SELECT t FROM TipTiketa t WHERE t.naziv LIKE :naziv", TipTiketa.class)
                .setParameter("naziv", "%" + naziv + "%")
                .getResultList();
    }

    public TipTiketa getById(Long id) {
        TipTiketa tipTiketa = em.find(TipTiketa.class, id);
        if (tipTiketa == null) {
            throw new ResourceNotFoundException("TipTiketa sa id=" + id + " nije pronađen.");
        }
        return tipTiketa;
    }
}
