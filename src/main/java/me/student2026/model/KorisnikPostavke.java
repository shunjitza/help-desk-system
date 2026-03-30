package me.student2026.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "korisnik_postavke")
public class KorisnikPostavke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean emailNotifikacije;
    private String tema;
    private String jezik;

    @OneToOne
    @JoinColumn(name = "korisnik_id", unique = true)
    private Korisnik korisnik;

    public KorisnikPostavke() {
    }

    public Long getId() {
        return id;
    }

    public boolean isEmailNotifikacije() {
        return emailNotifikacije;
    }

    public void setEmailNotifikacije(boolean emailNotifikacije) {
        this.emailNotifikacije = emailNotifikacije;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getJezik() {
        return jezik;
    }

    public void setJezik(String jezik) {
        this.jezik = jezik;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof KorisnikPostavke korisnikPostavke)) return false;
        return Objects.equals(id, korisnikPostavke.id) && emailNotifikacije == korisnikPostavke.emailNotifikacije && Objects.equals(tema, korisnikPostavke.tema) && Objects.equals(jezik, korisnikPostavke.jezik);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, emailNotifikacije, tema, jezik);
    }

    @Override
    public String toString() {
        return "KorisnikPostavke{id=" + id + ", emailNotifikacije=" + emailNotifikacije + ", tema='" + tema + "', jezik='" + jezik + "'}";
    }
}