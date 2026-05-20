package me.student2026.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tiketi")
public class Tiket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naslov;

    private String opis;

    private LocalDateTime rok;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "tiket_uploaded_files",
        joinColumns = @JoinColumn(name = "tiket_id"),
        inverseJoinColumns = @JoinColumn(name = "uploaded_file_id")
    )
    private List<UploadedFile> uploadedFiles = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "stadijum_id")
    private Stadijum stadijum;

    @ManyToOne
    @JoinColumn(name = "kriticnost_id")
    private Kriticnost kriticnost;

    @ManyToOne
    @JoinColumn(name = "tipovi_tiketa_id")
    private TipTiketa tipTiketa;

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

    public LocalDateTime getRok() {
        return rok;
    }

    public void setRok(LocalDateTime rok) {
        this.rok = rok;
    }

    public List<UploadedFile> getUploadedFiles() {
        return uploadedFiles;
    }

    public void setUploadedFiles(List<UploadedFile> uploadedFiles) {
        this.uploadedFiles = uploadedFiles;
    }

    public Stadijum getStadijum() {
        return stadijum;
    }

    public void setStadijum(Stadijum stadijum) {
        this.stadijum = stadijum;
    }

    public Kriticnost getKriticnost() {
        return kriticnost;
    }

    public void setKriticnost(Kriticnost kriticnost) {
        this.kriticnost = kriticnost;
    }

    public TipTiketa getTipTiketa() {
        return tipTiketa;
    }

    public void setTipTiketa(TipTiketa tipTiketa) {
        this.tipTiketa = tipTiketa;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tiket tiket)) return false;
        return Objects.equals(id, tiket.id) && Objects.equals(naslov, tiket.naslov) && Objects.equals(opis, tiket.opis) && Objects.equals(rok, tiket.rok) && Objects.equals(stadijum, tiket.stadijum) && Objects.equals(kriticnost, tiket.kriticnost) && Objects.equals(tipTiketa, tiket.tipTiketa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, naslov, opis, rok, stadijum, kriticnost, tipTiketa);
    }

    @Override
    public String toString() {
        return "Tiket{id=" + id + ", naslov='" + naslov + "', opis='" + opis + "', rok=" + rok + "}";
    }
}