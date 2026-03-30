package me.student2026.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tipovi_tiketa")
public class TipTiketa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naziv;
    private String opis;

    public TipTiketa() {
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
        if (!(o instanceof TipTiketa tipTiketa)) return false;
        return Objects.equals(id, tipTiketa.id) && Objects.equals(naziv, tipTiketa.naziv) && Objects.equals(opis, tipTiketa.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naziv, opis);
    }

    @Override
    public String toString() {
        return "TipTiketa{id=" + id + ", naziv='" + naziv + "', opis='" + opis + "'}";
    }
}