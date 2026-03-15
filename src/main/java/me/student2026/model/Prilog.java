package me.student2026.model;

import jakarta.persistence.*;

@Entity
@Table(name = "prilozi")
public class Prilog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazivFajla;

    private String putanja;

    private String tipFajla;

    public Prilog() {
    }

    public Long getId() {
        return id;
    }

    public String getNazivFajla() {
        return nazivFajla;
    }

    public void setNazivFajla(String nazivFajla) {
        this.nazivFajla = nazivFajla;
    }

    public String getPutanja() {
        return putanja;
    }

    public void setPutanja(String putanja) {
        this.putanja = putanja;
    }

    public String getTipFajla() {
        return tipFajla;
    }

    public void setTipFajla(String tipFajla) {
        this.tipFajla = tipFajla;
    }
}