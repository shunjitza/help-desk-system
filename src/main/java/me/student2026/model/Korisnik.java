package me.student2026.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "korisnici")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String email;
    private String lozinka;

    @OneToOne(mappedBy = "korisnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private KorisnikPostavke postavke;

    @OneToOne(mappedBy = "korisnik", cascade = CascadeType.ALL, orphanRemoval = true)
    private KorisnikProfil profil;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "korisnik_id")
    private List<TimezoneResponse> timezoneResponses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "korisnik_id")
    private List<CurrencyResponse> currencyResponses = new ArrayList<>();

    public Korisnik() {
    }

    public Long getId() {
        return id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public KorisnikPostavke getPostavke() {
        return postavke;
    }

    public void setPostavke(KorisnikPostavke postavke) {
        this.postavke = postavke;
        if (postavke != null) {
            postavke.setKorisnik(this);
        }
    }

    public List<TimezoneResponse> getTimezoneResponses() {
        return timezoneResponses;
    }

    public void setTimezoneResponses(List<TimezoneResponse> timezoneResponses) {
        this.timezoneResponses = timezoneResponses;
    }

    public KorisnikProfil getProfil() {
        return profil;
    }

    public void setProfil(KorisnikProfil profil) {
        this.profil = profil;
        if (profil != null) {
            profil.setKorisnik(this);
        }
    }

    public List<CurrencyResponse> getCurrencyResponses() {
        return currencyResponses;
    }

    public void setCurrencyResponses(List<CurrencyResponse> currencyResponses) {
        this.currencyResponses = currencyResponses;
    }

    @Override
    public boolean equals(Object o) {
    if (!(o instanceof Korisnik korisnik)) return false;
    return Objects.equals(id, korisnik.id) && Objects.equals(ime, korisnik.ime) && Objects.equals(email, korisnik.email) && Objects.equals(lozinka, korisnik.lozinka) && Objects.equals(postavke, korisnik.postavke) && Objects.equals(profil, korisnik.profil);
}
    @Override
    public int hashCode() {
        return Objects.hash(id, ime, email, lozinka, postavke, profil);
    }

    @Override
    public String toString() {
        return "Korisnik{id=" + id + ", ime='" + ime + "', email='" + email + "'}";
    }
}