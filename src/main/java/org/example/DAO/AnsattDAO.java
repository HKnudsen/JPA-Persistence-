package org.example.DAO;

import jakarta.persistence.*;
import org.example.Ansatt;
import org.example.Avdeling;

import java.util.List;
import java.util.Map;

public class AnsattDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("oblig3",
            Map.of("jakarta.persistence.jdbc.password", "pass"));

    // ------ CREATE -------- //
    public void createAnsatt(Ansatt a, int avd) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Avdeling avdeling = em.find(Avdeling.class, avd);
            a.setAvdeling(avdeling);
            em.persist(a);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }


    // ----------- READ ------------ //
    public Ansatt findAnsattWithPk(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Ansatt.class, id);
        }
    }

    public Ansatt findAnsattWithUsername(String usr) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Ansatt> query = em.createQuery(
                    "select u from Ansatt u where u.brukernavn = :search", Ansatt.class
            );
            query.setParameter("search", usr);
            return query.getSingleResult();
        }
    }

    public List<Ansatt> findAnsattWithSurname(String name) {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Ansatt> query = em.createQuery(
                    "select s from Ansatt where u.etternavn = :search", Ansatt.class
            );
            query.setParameter("search", name);
            return query.getResultList();
        }
    }

    public List<Ansatt> fetchAllAnsatt() {
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<Ansatt> query = em.createQuery(
                    "select a from Ansatt a", Ansatt.class
            );
            return query.getResultList();
        }
    }

    // ------------- UPDATE -------------- //
    public void setAnsattStilling(int id, String stilling) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Ansatt managedAnsatt = em.find(Ansatt.class, id);
            managedAnsatt.setStilling(stilling);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void setAnsattLonn(int id, int lonn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Ansatt managedAnsatt = em.find(Ansatt.class, id);
            managedAnsatt.setMonedslonn(lonn);
            tx.commit();
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }


    public void UpdateDepartmentForUser(int userId, int depId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, userId);
            Avdeling dep = em.find(Avdeling.class, depId);

            if (a.getAnsatt_id() != a.getAvdeling().getSjef().getAnsatt_id()) {
                a.setAvdeling(dep);
            }
            tx.commit();
            em.refresh(a);
        } catch (Throwable e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }

    }

}
