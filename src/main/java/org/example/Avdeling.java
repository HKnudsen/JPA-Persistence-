package org.example;

import jakarta.persistence.*;

@Entity
@Table(schema = "jpapersistoblig")
public class Avdeling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avdeling_id;
    private String navn;

    @OneToOne


}
