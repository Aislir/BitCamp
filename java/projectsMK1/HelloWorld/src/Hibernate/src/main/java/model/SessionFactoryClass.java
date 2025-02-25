package model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryClass {

    private static SessionFactory sessionFactory;

    static {
        try {
            //Configuriamo la sessione di hibernate utilizzando il file di configurazione xml
            sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Fermata.class)
                    .addAnnotatedClass(Biglietto.class)
                    .buildSessionFactory();

        } catch (Throwable ex){
            System.err.println("Errore durante la creazione della connessione: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}
