package model;

import jakarta.persistence.*;

@Entity //indichiamo che questa classe rappresenta una entita' gestita secondo JPA della tabella users
@Table(name="users")  //definizione specifica della relazione

public class User {

    //identifica il campo ID della tabella
    @Id
    //indichiamo come viene generato l'id che poi verra' salvato all'interno di una variabile
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    //rappresentiamo i campi (colonne) della tabella users
    private String username;
    private String email;
    private int age;

    //costruttore di default (è buona pratica)

    //metodi getter e setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
