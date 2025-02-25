package main;

import model.User;
import model.UserDAO;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        //aggiungiamo due utenti al database
        Integer userID1 = userDAO.addUser("Mario Rossi", "mario@mail.it", 30);
        Integer userID2 = userDAO.addUser("Luigi Verdi", "luigi@mail.it", 40);

        System.out.println("Utente con UserID1 inserito con ID: " + userID1);
        System.out.println("Utente con UserID2 inserito con ID: " + userID2);

        //modifica utente selezionato tramite id
        userDAO.updateUser(userID1, "Marco Rosi", "marco@mail.it", 30);
        System.out.println("Dati utente con ID: " + userID1 + " aggiornati.");

        //recupero di un utente in base all'id
        User user = userDAO.getUser(userID2);
        System.out.println("Dettagli utente con ID: " + userID1);
        printUserDetails(user);

        //recupero e stampa di tutti gli utenti
        List<User> users = userDAO.getAllUsers();
        System.out.println("Elenco di tutti gli utenti:");
        printUserList(users);

        //elimina un utente
        userDAO.deleteUser(userID1);
        System.out.println("Utente eliminato.");
    }

    private static void printUserDetails(User user) {
        if (user != null) {
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Age: " + user.getAge());
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    //metodo per la stampa di tutti gli utenti
    private static void printUserList(List<User> users) {
        if (users != null && !users.isEmpty()) {
            for (User user: users) {
                printUserDetails(user);
                System.out.println();
            }
        } else {
            System.out.println("Nessun utente nel database.");
        }
    }

}
