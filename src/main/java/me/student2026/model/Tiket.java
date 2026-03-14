package me.student2026.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tiket")
public class Tiket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naslov;
    private String opis;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private Korisnik korisnik;

    public Tiket() {
    }

    public Long getId() {
        return id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
