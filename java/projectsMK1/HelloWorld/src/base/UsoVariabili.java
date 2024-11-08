package base;

public class UsoVariabili {

    public static void main(String[] args){
        System.out.println("Hello World!");

        int numInt = 200;   //dichiarazione e inizializzazione di una variabile di tipo int
        System.out.println(numInt);

        byte numByte = (byte) numInt; //dichiarazione e inizializzazione tramite casting di una variabile di tipo byte

        System.out.println(numByte); //200 non ci sta all'interno di byte, dunque diventa negativo

        double numDouble = numInt;
        System.out.println(numDouble);

        boolean bool = true;
        if (bool){
            System.out.println("La mia variabile e': " +bool);
        }

        //nuova assegnazione alle variabili esistenti

        numInt = 3;
        numByte = 12;
        numDouble = 3.12354467675;
        bool = false;

        System.out.println(numByte + " " + numInt + " " + numDouble + " " + bool);

        //COSTANTI         //e' prassi scrivere i nomi delle costanti in maiuscolo
        final int COSTANTE = 5;

        //provare a modificare la costante dara un errore
        //COSTANTE = 2;
    }
}
