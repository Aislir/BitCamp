package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ContattoFornitoreDAO {

    private static SessionFactory sessionFactory;

    static {
        try {
            //Configuriamo la sessione di hibernate utilizzando il file di configurazione xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Fornitore.class)
                    .addAnnotatedClass(ContattoFornitore.class)
                    .buildSessionFactory();

        } catch (Throwable ex){
            System.err.println("Errore durante la creazione della connessione: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static List<ContattoFornitore> getAllContatti() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<ContattoFornitore> contattoList = null;

        try{
            transaction = session.beginTransaction();
            contattoList = session.createQuery("FROM ContattoFornitore", ContattoFornitore.class).list();
            for (ContattoFornitore contattoFornitore : contattoList) {
                System.out.println(contattoFornitore.getId());
                System.out.println(contattoFornitore.getEmail());
                System.out.println(contattoFornitore.getContatti());
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Errore nella ricerca dei fornitori");
            if(transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }

        return contattoList;
    }

}
