package avanzato.oggetti;

public class Main {

    public static void main(String[] args) {

        Persona persona = new Persona("Mario", "Rossi", 40);

        Studente studente = new Studente("Luca", "Bianchi", 20, "12343", "Informatica");

        System.out.println(studente); //fa partire in automotico il metodo toString

        System.out.println(persona); //fa partire in automotico il metodo toString

        studente.setNome("Pippo");

        System.out.println(studente); //fa partire in automotico il metodo toString

    }
}
