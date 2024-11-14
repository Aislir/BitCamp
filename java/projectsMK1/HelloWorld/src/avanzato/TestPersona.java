package avanzato;

public class TestPersona { //classe per testing sulla classe Persona

    public static void main(String[] args) {

        //creo istanze della classe Persona
        Persona p1 = new Persona("Mario", 20);
        Persona p2 = new Persona();
        Persona p3 = new Persona("Luigi");

        p2.setNome("Bob");
        p2.setEta(34);
        p3.setEta(55);

        System.out.println("L'eta di "+p2.getNome()+ " e' "+ p2.getEta());
        System.out.println("L'eta di " +p3.getNome()+ " e' " + p3.getEta());
    }
}
