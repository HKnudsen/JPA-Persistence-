package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "jpapersistoblig")
public class Avdeling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avdeling_id;
    private String navn;

    @OneToOne
    @JoinColumn(name = "sjef")
    private Ansatt sjef;

    @OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER)
    private List<Ansatt> ansatte;

    public Avdeling() {}

    public Avdeling(String navn, Ansatt sjef) {
        this.navn = navn;
        this.sjef = sjef;
    }

    public void setAvdeling_id(int avdeling_id) {
        this.avdeling_id = avdeling_id;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setSjef(Ansatt sjef) {
        this.sjef = sjef;
    }

    public int getAvdeling_id() {
        return avdeling_id;
    }

    public String getNavn() {
        return navn;
    }

    public Ansatt getSjef() {
        return sjef;
    }

    public List<Ansatt> getAnsatte() {
        return ansatte;
    }

    @Override
    public String toString() {
        return "Avdeling{" +
                "avdeling_id=" + avdeling_id +
                ", navn='" + navn + '\'' +
                ", sjef=" + sjef +
                '}';
    }
}
