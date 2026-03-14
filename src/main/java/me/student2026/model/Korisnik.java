package me.student2026.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "korisnik")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ime;
    private String prezime;
    private String email;
    private String korisnickoIme;
    private String lozinka;
    private boolean aktivan;

    @JsonIgnore
    @OneToMany(mappedBy = "korisnik")
    private List<Tiket> tiketi;

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

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public List<Tiket> getTiketi() {
        return tiketi;
    }

    public void setTiketi(List<Tiket> tiketi) {
        this.tiketi = tiketi;
    }
}
