package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.Korisnik;

import java.util.List;

@Dependent
public class KorisnikService {

    @Inject
    private EntityManager em;

    @Transactional
    public Korisnik createKorisnik(Korisnik korisnik) throws ResourceNotFoundException {
        if (korisnik == null) {
            throw new ResourceNotFoundException("Korisnik nije proslijedjen");
        }
        if (korisnik.getIme() == null || korisnik.getIme().isEmpty()) {
            throw new ResourceNotFoundException("Ime je prazno");
        }
        if (korisnik.getEmail() == null || korisnik.getEmail().isEmpty()) {
            throw new ResourceNotFoundException("Email je prazan");
        }
        if (korisnik.getLozinka() == null || korisnik.getLozinka().isEmpty()) {
            throw new ResourceNotFoundException("Lozinka je prazna");
        }
        if (korisnik.getPostavke() != null) {
            korisnik.getPostavke().setKorisnik(korisnik);
        }
        return em.merge(korisnik);
    }

    @Transactional
    public List<Korisnik> getAllKorisnici() throws ResourceNotFoundException {
        List<Korisnik> korisnici = em.createQuery("from Korisnik", Korisnik.class).getResultList();
        if (korisnici.isEmpty()) {
            throw new ResourceNotFoundException("Nema korisnika.");
        }
        return korisnici;
    }

    public List<Korisnik> getByIme(String ime) {
        return em.createQuery("SELECT k FROM Korisnik k WHERE k.ime = :ime", Korisnik.class)
                .setParameter("ime", ime)
                .getResultList();
    }

    public Korisnik getById(Long id) {
        Korisnik korisnik = em.find(Korisnik.class, id);
        if (korisnik == null) {
            throw new ResourceNotFoundException("Korisnik sa id=" + id + " nije pronađen.");
        }
        return korisnik;
    }
}
