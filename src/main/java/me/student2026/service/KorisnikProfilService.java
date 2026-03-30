package me.student2026.service;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.student2026.exception.ResourceNotFoundException;
import me.student2026.model.KorisnikProfil;

import java.util.List;

@Dependent
public class KorisnikProfilService {

    @Inject
    private EntityManager em;

    @Transactional
    public KorisnikProfil createProfil(KorisnikProfil profil) throws ResourceNotFoundException {
        if (profil == null) {
            throw new ResourceNotFoundException("KorisnikProfil nije proslijedjen");
        }
        if (profil.getTelefon() == null || profil.getTelefon().isEmpty()) {
            throw new ResourceNotFoundException("Telefon je prazan");
        }
        if (profil.getBio() == null || profil.getBio().isEmpty()) {
            throw new ResourceNotFoundException("Bio je prazan");
        }
        if (profil.getKorisnik() != null) {
            profil.getKorisnik().setProfil(profil);
        }
        return em.merge(profil);
    }

    @Transactional
    public List<KorisnikProfil> getAllProfili() throws ResourceNotFoundException {
        List<KorisnikProfil> profili = em.createQuery("from KorisnikProfil", KorisnikProfil.class).getResultList();
        if (profili.isEmpty()) {
            throw new ResourceNotFoundException("Nema korisnik profila.");
        }
        return profili;
    }

    public KorisnikProfil getByKorisnikId(Long korisnikId) {
        return em.createQuery("SELECT p FROM KorisnikProfil p WHERE p.korisnik.id = :korisnikId", KorisnikProfil.class)
                .setParameter("korisnikId", korisnikId)
                .getResultStream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Profil za korisnika sa id=" + korisnikId + " nije pronađen."));
    }

    public KorisnikProfil getById(Long id) {
        KorisnikProfil profil = em.find(KorisnikProfil.class, id);
        if (profil == null) {
            throw new ResourceNotFoundException("KorisnikProfil sa id=" + id + " nije pronađen.");
        }
        return profil;
    }
}
