package model;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UserDAO {
    //creazione di una factory di connessioni
    private static SessionFactory factory;

    static {
        try {
            //Configuriamo la sessione di hibernate utilizzando il file di configurazione xml
            factory = new Configuration().configure().buildSessionFactory();

        } catch (Throwable ex){
            System.err.println("Errore durante la creazione della connessione: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    //metodo per aggiungere un nuovo utente al database
    public void addUser(String username, String email, int age) {
        //apriamo una nuova connessione
        Session session = factory.openSession();
        Transaction transaction = null;
        try{
            //inizia una nuova transazione delle informazioni
            transaction = session.beginTransaction();
            //crea una nuova istanza User
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setAge(age);
            //salva utente nel database e torna indietro l'id assegnato
            session.persist(user);
            //conferma la transazione
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void updateUser(Integer userId, String username, String email, int age){

        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            user.setUsername(username);
            user.setEmail(email);
            user.setAge(age);
            session.merge(user);

        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteUser(Integer userId){
        Session session = factory.openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            User user = session.get(User.class, userId);
            session.remove(user);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public User getUser(Integer userId) {
        Session session = factory.openSession();
        Transaction transaction = null;
        User user = null;
        try {
            transaction = session.beginTransaction();
            user = session.get(User.class, userId);
            transaction.commit();

        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return user;
    }

    public List<User> getAllUsers(){
        Session session = factory.openSession();
        Transaction transaction = null;
        List<User> users = null;
        try{
            transaction = session.beginTransaction();
            users = session.createQuery("FROM User").list();

        } catch (Exception e){
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

}
