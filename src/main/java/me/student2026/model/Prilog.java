package me.student2026.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prilozi")
public class Prilog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazivFajla;

    private String putanja;

    private String tipFajla;

    @ManyToOne
    @JoinColumn(name = "tiket_id")
    private Tiket tiket;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Prilog prilog)) return false;
        return Objects.equals(id, prilog.id) && Objects.equals(nazivFajla, prilog.nazivFajla) && Objects.equals(putanja, prilog.putanja) && Objects.equals(tipFajla, prilog.tipFajla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazivFajla, putanja, tipFajla);
    }

    @Override
    public String toString() {
        return "Prilog{id=" + id + ", nazivFajla='" + nazivFajla + "', putanja='" + putanja + "', tipFajla='" + tipFajla + "'}";
    }
}