package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.KorisnikPostavke;

import java.util.List;

@Dependent
public class KorisnikPostavkeService {

    @Inject
    private EntityManager em;

    @Transactional
    public KorisnikPostavke createPostavke(KorisnikPostavke postavke) throws ResourceNotFoundException {
        if (postavke == null) {
            throw new ResourceNotFoundException("KorisnikPostavke nije proslijedjena");
        }
        if (postavke.getTema() == null || postavke.getTema().isEmpty()) {
            throw new ResourceNotFoundException("Tema je prazna");
        }
        if (postavke.getJezik() == null || postavke.getJezik().isEmpty()) {
            throw new ResourceNotFoundException("Jezik je prazan");
        }
        if (postavke.getKorisnik() != null) {
            postavke.getKorisnik().setPostavke(postavke);
        }
        return em.merge(postavke);
    }

    @Transactional
    public List<KorisnikPostavke> getAllPostavke() throws ResourceNotFoundException {
        List<KorisnikPostavke> postavke = em.createQuery("from KorisnikPostavke", KorisnikPostavke.class).getResultList();
        if (postavke.isEmpty()) {
            throw new ResourceNotFoundException("Korisnik nema postavki.");
        }
        return postavke;
    }

    public KorisnikPostavke getById(Long id) {
        KorisnikPostavke postavke = em.find(KorisnikPostavke.class, id);
        if (postavke == null) {
            throw new ResourceNotFoundException("KorisnikPostavke sa id=" + id + " nisu pronađene.");
        }
        return postavke;
    }
}
