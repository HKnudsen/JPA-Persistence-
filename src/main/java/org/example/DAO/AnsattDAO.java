package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Ansatt;

import java.util.Map;

public class AnsattDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oblig3",
            Map.of("jakarta.persistence.jdbc.password", "pass"));

    public Ansatt finnAnsattMedPk(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Ansatt.class, id);
        }
    }

}
