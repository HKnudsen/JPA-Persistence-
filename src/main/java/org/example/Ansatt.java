package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(schema = "jpapersistoblig")
public class Ansatt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ansatt_id;
    private String brukernavn;
    private String fornavn;
    private String etternavn;
    private LocalDate ansettelse_dato;
    private String stilling;
    private int monedslonn;
    @ManyToOne
    @JoinColumn(name = "avdeling")
    private Avdeling avdeling;

    public Ansatt() {}

    public Ansatt(String brukernavn, String fornavn, String etternavn, String dato, String stilling, int lønn) {
        this.brukernavn         = brukernavn;
        this.fornavn            = fornavn;
        this.etternavn          = etternavn;
        this.ansettelse_dato    = LocalDate.parse(dato);
        this.stilling           = stilling;
        this.monedslonn         = lønn;

    }

    public void setAnsatt_id(int ansatt_id) {
        this.ansatt_id = ansatt_id;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setAnsettelse_dato(LocalDate ansettelse_dato) {
        this.ansettelse_dato = ansettelse_dato;
    }

    public void setStilling(String stilling) {
        this.stilling = stilling;
    }

    public void setMonedslonn(int monedslonn) {
        this.monedslonn = monedslonn;
    }

    public int getAnsatt_id() {
        return ansatt_id;
    }

    public String getBrukernavn() {
        return brukernavn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public LocalDate getAnsettelse_dato() {
        return ansettelse_dato;
    }

    public String getStilling() {
        return stilling;
    }

    public int getMonedslonn() {
        return monedslonn;
    }

    public Avdeling getAvdeling() {
        return avdeling;
    }

    public void setAvdeling(Avdeling avdeling) {
        this.avdeling = avdeling;
    }



    @Override
    public String toString() {
        return ansatt_id + " | " + brukernavn + " | " + fornavn +
                " " + etternavn + " | " + stilling + " | " + monedslonn + " | ";
    }
}
