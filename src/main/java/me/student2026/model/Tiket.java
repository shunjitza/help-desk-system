package me.student2026.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tiketi")
public class Tiket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naslov;

    private String opis;

    @Transient
    private List<Prilog> prilozi;

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

    public List<Prilog> getPrilozi() {
        return prilozi;
    }

    public void setPrilozi(List<Prilog> prilozi) {
        this.prilozi = prilozi;
    }
}