package me.student2026.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "stadijumi")
public class Stadijum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String opis;

    public Stadijum() {
    }

    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Stadijum stadijum)) return false;
        return Objects.equals(id, stadijum.id) && Objects.equals(naziv, stadijum.naziv) && Objects.equals(opis, stadijum.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, opis);
    }

    @Override
    public String toString() {
        return "Stadijum{id=" + id + ", naziv='" + naziv + "', opis='" + opis + "'}";
    }
}