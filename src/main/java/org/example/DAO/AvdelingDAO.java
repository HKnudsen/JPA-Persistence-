package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Ansatt;
import org.example.Avdeling;

import java.util.List;
import java.util.Map;

public class AvdelingDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oblig3",
            Map.of("jakarta.persistence.jdbc.password", "pass"));

    public Avdeling finnAvdelingMedId(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Avdeling.class, id);
        }
    }

    public List<Ansatt> hentAnsatteIAvdeling(int avdId) {
        EntityManager em = emf.createEntityManager();
        List<Ansatt> ansatte;
        try {
            Avdeling avdeling = em.find(Avdeling.class, avdId);
            ansatte = avdeling.getAnsatte();
            for (Ansatt a : ansatte) {
                if (a.getAnsatt_id() == avdeling.getSjef().getAnsatt_id()) {
                    System.out.println(a.toString().toUpperCase());
                } else {
                    System.out.println(a);
                }
            }

        } finally {
            em.close();
        }
        return ansatte;
    }
}
