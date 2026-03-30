package me.student2026.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "kriticnosti")
public class Kriticnost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String opis;

    public Kriticnost() {
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
        if (!(o instanceof Kriticnost kriticnost)) return false;
        return Objects.equals(id, kriticnost.id) && Objects.equals(naziv, kriticnost.naziv) && Objects.equals(opis, kriticnost.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, opis);
    }

    @Override
    public String toString() {
        return "Kriticnost{id=" + id + ", naziv='" + naziv + "', opis='" + opis + "'}";
    }
}