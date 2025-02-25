package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class BigliettoDAO {

    private EntityManager em;
    FermataDAO fermataDAO = new FermataDAO();

    public BigliettoDAO() {}

    public void addBiglietto(Biglietto biglietto) {
        em = JPAUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            if (biglietto.getData() == null) {
                biglietto.setData(LocalDateTime.now());
            }
            if (biglietto.getFermata() == null) {
                biglietto.setFermata(fermataDAO.getFermataById(1));
            }
            em.persist(biglietto);
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

    public Biglietto getBigliettoById(int id) {

        em = JPAUtil.getEntityManager();
        Biglietto biglietto = null;
        try {
            em.getTransaction().begin();
            biglietto = em.find(Biglietto.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return biglietto;
    }

}
