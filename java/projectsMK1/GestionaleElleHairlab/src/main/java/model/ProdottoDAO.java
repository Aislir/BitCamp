package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public class ProdottoDAO{
    private EntityManager em;

    public void addProdotto(String nome, TipoProdotto tipoProdotto, String codice, double contenuto, Marca marca, Fornitore fornitore) {
        em = JPAUtil.getEntityManager();
        try{
            em.getTransaction().begin();
            Prodotto prodotto = new Prodotto();
            prodotto.setNome(nome);
            prodotto.setTipo(tipoProdotto);
            prodotto.setCodice(codice);
            prodotto.setContenuto(contenuto);
            prodotto.setMarca(marca);
            prodotto.setFornitore(fornitore);

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
        try{
            em.getTransaction().begin();
            prodotto = em.find(Prodotto.class, id);
            prodotto.setNome(nomeProdotto);
            prodotto.setCodice(codice);
            prodotto.setTipo(tipo);
            prodotto.setContenuto(contenuto);
            prodotto.setMarca(marca);
            //String hql = "FROM Fornitore F WHERE F.nome = :nome";
            //Query query = em.createQuery(hql, Fornitore.class);
            //query.setParameter("nome", nome);

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

    public void deleteProdotto(List<Prodotto> prodottiList) {
        em = JPAUtil.getEntityManager();

        try{
            em.getTransaction().begin();


            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nell'eliminazione del prodotto");
            if (em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
        } finally {
            System.out.println(em.getTransaction().isActive());
            em.close();
        }
    }

}
