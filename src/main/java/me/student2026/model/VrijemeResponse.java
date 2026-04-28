package me.student2026.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class VrijemeResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vrijeme_seq")
    @SequenceGenerator(name = "vrijeme_seq", sequenceName = "vrijeme_seq", allocationSize = 1)
    private Long id;

    @Column(unique = true)
    private String grad;

    private String temperature;
    private String wind;
    private String description;
    private String humidity;
    private String feelsLike;
    private String uvIndex;

    public VrijemeResponse() {
    }

    public VrijemeResponse(String grad, String temperature, String wind, String description, String humidity, String feelsLike, String uvIndex) {
        this.grad = grad;
        this.temperature = temperature;
        this.wind = wind;
        this.description = description;
        this.humidity = humidity;
        this.feelsLike = feelsLike;
        this.uvIndex = uvIndex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getUvIndex() {
        return uvIndex;
    }

    public void setUvIndex(String uvIndex) {
        this.uvIndex = uvIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        VrijemeResponse that = (VrijemeResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(grad, that.grad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grad);
    }

    @Override
    public String toString() {
        return "VrijemeResponse{" +
                "id=" + id +
                ", grad='" + grad + '\'' +
                ", temperature='" + temperature + '\'' +
                ", wind='" + wind + '\'' +
                ", description='" + description + '\'' +
                ", humidity='" + humidity + '\'' +
                ", feelsLike='" + feelsLike + '\'' +
                ", uvIndex='" + uvIndex + '\'' +
                '}';
    }
}
