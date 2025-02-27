package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class FornitoreDAO {

    private EntityManager em;

    public void addFornitore(Fornitore fornitore, ContattoFornitore contatto) {
        em = JPAUtil.getEntityManager();

        try{
            System.out.println("Entrati nella session");
            em.getTransaction().begin();
            fornitore.addContatto(contatto);
            em.persist(fornitore);
            em.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        System.out.println("Usciti dalla session");
    }

    public List<Fornitore> getAllFornitore() {
        em = JPAUtil.getEntityManager();
        List<Fornitore> fornitoreList = null;

        try{
            em.getTransaction().begin();
            fornitoreList = em.createQuery("FROM Fornitore", Fornitore.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nella ricerca dei fornitori");
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return fornitoreList;
    }

    public Fornitore getFornitoreById(int id) {
        em = JPAUtil.getEntityManager();
        Fornitore fornitore = null;
        try{
            em.getTransaction().begin();
            fornitore = em.find(Fornitore.class, id);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nel retrieval del fornitore By ID");
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return fornitore;
    }

    public Fornitore getFornitoreByNome(String nome) {
        em = JPAUtil.getEntityManager();
        Fornitore fornitore = null;
        try{
            System.out.println("Nella session il nome e': " + nome);
            em.getTransaction().begin();
            String hql = "FROM Fornitore F WHERE F.nome = :nome";
            Query query = em.createQuery(hql, Fornitore.class);
            query.setParameter("nome", nome);

            fornitore = (Fornitore) query.getResultList().getFirst();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nel retrieval del fornitore By Nome");
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return fornitore;
    }

    public void deleteFornitore(List <Fornitore> fornitoreList) {
        em = JPAUtil.getEntityManager();

        try{
            em.getTransaction().begin();
            for (Fornitore fornitore : fornitoreList) {
                Fornitore matchedFornitore = em.find(Fornitore.class, fornitore.getId());
                em.remove(matchedFornitore);
                System.out.println("Il fornitore e' stato eliminato");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore durante l'eliminazione della fornitore");
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public void updateFornitore(int id, String nome, String rappresentante, String email, String contatto) {
        em = JPAUtil.getEntityManager();
        Fornitore fornitore = null;
        try{
            em.getTransaction().begin();
            fornitore = em.find(Fornitore.class, id);
            fornitore.setNome(nome);
            fornitore.setRappresentante(rappresentante);
            fornitore.getContatti().getFirst().setEmail(email);
            fornitore.getContatti().getFirst().setContatti(contatto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore durante la modifica del fornitore");
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

}
