package me.student2026.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.model.Korisnik;

import java.util.List;

@ApplicationScoped
public class KorisnikService {

    @Inject
    EntityManager em;

    @Transactional
    public Korisnik createKorisnik(Korisnik korisnik) {
        return em.merge(korisnik);
    }

    public List<Korisnik> getAllKorisnici() {
        return em.createQuery("from Korisnik", Korisnik.class).getResultList();
    }
}
