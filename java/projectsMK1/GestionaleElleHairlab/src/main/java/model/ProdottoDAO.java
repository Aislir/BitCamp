package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.TransactionManager;
import main.Main;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO{
/*
    private static SessionFactory sessionFactory;

    //metodo per aggiungere un nuovo utente al database
    public void addProdotto(String nome, TipoProdotto tipo, String codice, double contenuto, Marche marca, Fornitore fornitore) {
        Session session = Main.getCurrentSessionFromConfig();
        Transaction transaction = null;
        try{
            //inizio nuova transazione con il database attraverso hibernate
            transaction = session.getTransaction();
            transaction.begin();

            //creazione nuova istanza prodotto
            Prodotto prodotto = new Prodotto();
            //riempimento proprieta' prodotto
            prodotto.setNome(nome);
            prodotto.setTipo(tipo);
            prodotto.setCodice(codice);
            prodotto.setContenuto(contenuto);
            prodotto.setMarca(marca);
            //prodotto.setFornitore(fornitore);

            //preparazione dell'istanza prodotto per il salvataggio nel DB
            session.persist(prodotto);
            //effettiva transazione con il DB
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Errore durante l'inserimento del prodotto");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void modifyProdotto(int id, String nome, TipoProdotto tipo, String codice, double contenuto, Marche marca, Fornitore fornitore, int quantita) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;

        try{
            //inizio transazione
            transaction = entityManager.getTransaction();
            transaction.begin();
            //ottenimento prodotto da dover modificare
            Prodotto prodotto = entityManager.find(Prodotto.class, id);
            //modifica proprieta prodotto
            prodotto.setNome(nome);
            prodotto.setTipo(tipo);
            prodotto.setCodice(codice);
            prodotto.setContenuto(contenuto);
            prodotto.setMarca(marca);
            //prodotto.setFornitore(fornitore);
            prodotto.setQuantita(quantita);
            //modifica nel DB
            entityManager.merge(prodotto);
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Errore durante la modifica del prodotto");
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }

    public List<Prodotto> getAllProdotti() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        List<Prodotto> prodotti = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            prodotti = entityManager.createQuery("FROM Prodotto").getResultList();
        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Errore durante l'ottenimento dei prodotti");
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return prodotti;
    }

    public List<Prodotto> getProdottiByNome(String nome) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        //dichiarazione per l'utilizzo della Criteria API
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        //CriteriaQuery e' lo strumento utilizzato per fare le query su una specifica classe
        CriteriaQuery<Prodotto> criteriaQuery = criteriaBuilder.createQuery(Prodotto.class);
        //Root rappresenta l'entita, ovvero la tabella su cui viene fatta la query
        Root<Prodotto> root = criteriaQuery.from(Prodotto.class);
        List<Prodotto> prodotti = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            //creazione query
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("nome"), nome));
            //utilizzo query e ritorno risultati in prodotti
            prodotti = entityManager.createQuery(criteriaQuery).getResultList();

            if (prodotti.isEmpty()) {
                System.out.println("Nessun prodotto non trovato con questo nome: " + nome);
                return null;
            }

        } catch (HibernateException e) {
            transaction.rollback();
            System.out.println("Errore durante la ricerca dei prodotti per nome");
        } finally {
            entityManager.close();
        }
        return prodotti;
    }

    public List<Prodotto> getProdottiByTipo(TipoProdotto tipo) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Prodotto> criteriaQuery = criteriaBuilder.createQuery(Prodotto.class);
        Root<Prodotto> root = criteriaQuery.from(Prodotto.class);
        List<Prodotto> prodotti = null;
        List<Prodotto> prodottiByTipo = new ArrayList<>();

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("tipo"), tipo));
            prodotti = entityManager.createQuery(criteriaQuery).getResultList();
            if (prodotti.isEmpty()) {
                System.out.println("nessun prodotto trovato per questo tipo: " + tipo);
                return null;
            }

        } catch (HibernateException e){
            transaction.rollback();
            System.out.println("Errore durante la ricerca dei prodotti per il tipo " + tipo);
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return prodottiByTipo;
    }

    public List<Prodotto> getProdottiByCodice(int codice) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Prodotto> criteriaQuery = criteriaBuilder.createQuery(Prodotto.class);
        Root<Prodotto> root = criteriaQuery.from(Prodotto.class);
        List<Prodotto> prodotti = null;
        List<Prodotto> prodottiByCodice = new ArrayList<>();

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("codice"), codice));
            prodotti = entityManager.createQuery(criteriaQuery).getResultList();
            if (prodotti.isEmpty()) {
                System.out.println("Nessun prodotto trovato per questo codice " + codice);
                return null;
            }

        } catch (HibernateException e){
            transaction.rollback();
        } finally {
            entityManager.close();
        }
        return prodottiByCodice;
    }

*/
}
