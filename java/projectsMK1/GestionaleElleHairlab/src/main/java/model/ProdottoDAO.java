package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ProdottoDAO{
    private EntityManager em;
    FornitoreDAO fornitoreDAO = new FornitoreDAO();

    public void addProdotto(Prodotto prodotto, String nome) {
        em = JPAUtil.getEntityManager();
        Fornitore fornitore = null;
        try{
            em.getTransaction().begin();
            String hql = "FROM Fornitore F WHERE F.nome = :nome";
            Query query = em.createQuery(hql, Fornitore.class);
            query.setParameter("nome", nome);

            fornitore = (Fornitore) query.getResultList().getFirst();
            System.out.println(fornitore.getNome());
            prodotto.addFornitore(fornitore);
            em.persist(prodotto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nell'aggiunta del prodotto");
            if (em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public List<Prodotto> getAllProdotti() {
        em = JPAUtil.getEntityManager();
        List<Prodotto> prodottiList = null;

        try{
            em.getTransaction().begin();
            prodottiList = em.createQuery("FROM Prodotto", Prodotto.class).getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nella ricerca dei fornitori");
            if(em.getTransaction() != null){
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
        return prodottiList;
    }

    public void updateProdotto(int id, String nomeProdotto, String codice, TipoProdotto tipo, double contenuto, Marca marca, String nome) {
        em = JPAUtil.getEntityManager();
        Prodotto prodotto = null;
        Fornitore fornitore = null;
        try{
            em.getTransaction().begin();
            prodotto = em.find(Prodotto.class, id);
            prodotto.setNome(nomeProdotto);
            prodotto.setCodice(codice);
            prodotto.setTipo(tipo);
            prodotto.setContenuto(contenuto);
            prodotto.setMarca(marca);
            String hql = "FROM Fornitore F WHERE F.nome = :nome";
            Query query = em.createQuery(hql, Fornitore.class);
            query.setParameter("nome", nome);

            fornitore = (Fornitore) query.getResultList().getFirst();
            prodotto.setFornitore(fornitore);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nella modifica del prodotto");
            if (em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }
}
