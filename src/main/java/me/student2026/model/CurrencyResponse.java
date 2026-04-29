package me.student2026.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class CurrencyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currency_seq")
    @SequenceGenerator(name = "currency_seq", sequenceName = "currency_seq", allocationSize = 1)
    private Long id;
    private String from;
    private String to;
    private double rate;
    private String date;
    private String source;
    private double value;
    private double convertedValue;

    public CurrencyResponse() {
    }

    public CurrencyResponse(String from, String to, double rate, String date, String source, double value, double convertedValue) {
        this.from = from;
        this.to = to;
        this.rate = rate;
        this.date = date;
        this.source = source;
        this.value = value;
        this.convertedValue = convertedValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(double convertedValue) {
        this.convertedValue = convertedValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyResponse that = (CurrencyResponse) o;
        return Double.compare(rate, that.rate) == 0 && Double.compare(value, that.value) == 0 && Double.compare(convertedValue, that.convertedValue) == 0 && Objects.equals(id, that.id) && Objects.equals(from, that.from) && Objects.equals(to, that.to) && Objects.equals(date, that.date) && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, rate, date, source, value, convertedValue);
    }

    @Override
    public String toString() {
        return "CurrencyResponse{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", rate=" + rate +
                ", date='" + date + '\'' +
                ", source='" + source + '\'' +
                ", value=" + value +
                ", convertedValue=" + convertedValue +
                '}';
    }
}
