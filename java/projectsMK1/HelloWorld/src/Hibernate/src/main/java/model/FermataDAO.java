package model;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.time.LocalDateTime;

public class FermataDAO {

    private EntityManager em;

    public FermataDAO() {}

    public void addFermata(Fermata fermata) {
        em = JPAUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            em.persist(fermata);
            em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if(em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
           em.close();
        }
    }

    public Fermata getFermataById(int id) {
        em = JPAUtil.getEntityManager();
        Fermata fermata = null;

        try{
            em.getTransaction().begin();
            fermata = em.find(Fermata.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return fermata;
    }

    public Fermata getFermataByLuogo(String luogo) {
        em = JPAUtil.getEntityManager();
        Fermata fermata = null;

        try{
            em.getTransaction().begin();
            fermata = em.find(Fermata.class, luogo);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if(em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return fermata;
    }

}
