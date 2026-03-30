package me.student2026.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "korisnik_profil")
public class KorisnikProfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bio;
    private String avatarUrl;
    private String telefon;

    @OneToOne
    @JoinColumn(name = "korisnik_id", unique = true)
    private Korisnik korisnik;

    public KorisnikProfil() {
    }

    public Long getId() {
        return id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof KorisnikProfil korisnikProfil)) return false;
        return Objects.equals(id, korisnikProfil.id) && Objects.equals(bio, korisnikProfil.bio) && Objects.equals(avatarUrl, korisnikProfil.avatarUrl) && Objects.equals(telefon, korisnikProfil.telefon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bio, avatarUrl, telefon);
    }

    @Override
    public String toString() {
        return "KorisnikProfil{id=" + id + ", bio='" + bio + "', avatarUrl='" + avatarUrl + "', telefon='" + telefon + "'}";
    }
}
