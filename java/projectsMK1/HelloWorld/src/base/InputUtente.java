package base;

//importiamo la libreria che si serve
import java.util.Scanner;

public class InputUtente {

    public static void main(String[] args) {

        //creazione di un oggetto della libreria Scanner per poterne utilizzare le proprieta'
        Scanner input = new Scanner(System.in); //System.in specifica al costruttore di Scanner
                                                //che ci serve per l'input


        //primo input (stringa)
        System.out.print("Inserisci una stringa: ");
        String inputUtente = input.nextLine(); //nextLine prende come input l'intera riga. next solo il primo elemento (separato da un spazio dal secondo elemento)
        System.out.println(inputUtente);

        //secondo input (int)
        System.out.print("Inserisci un numero: ");
        int numInt = input.nextInt();
        System.out.println(numInt);

        //terzo input (double) ------ bisogna scrivere il numero con il punto invece che con la virgola
        //altrimenti da errore (causa localizzazione. L'inglese US usa il punto)
        System.out.print("Inserisci un numero decimale: ");
        double numDec = input.nextDouble();
        System.out.println(numDec);

        //quarto input (char)
        System.out.print("Inserisci un carattere: ");
        char carattere = input.next().charAt(0); //va a prendere il primo carattere inserito, a prescindere della stringa inserita
        System.out.println(carattere);

        //quinto input (prima parola di una stringa)
        System.out.print("Scrivi una frase: ");
        String parola = input.next(); //prende come input SOLO il primo elemento inserito, il resto lo lascia dentro lo scanner
        System.out.println(parola);

        //dato input.next() di riga 38, noi non sappiamo se l'input ha degli spazi. Se ce li avesse, next() andrebbe a
        //prendere tutto cio' che viene prima, ma cio che viene dopo lo lascierebbe li. Se noi usassimo nuovamente next()
        //questo andrebbe a prendere tutto cio' che e' rimasto fino all'eventuale successivo spazio.
        //Per prevenire questo comportamento, diciamo allo scanner di andare alla riga successiva per "sbarazzarci" della spazzatura
        input.nextLine();
        //La riga dello scanner adesso e' vuota

        //lettura di piu' input sulla stessa riga
        System.out.print("Inserisci un numero intero, un numero decimale, una stringa ed un carattere: ");
        int intero = input.nextInt();
        double decimale = input.nextDouble();
        String stringaUtente = input.next();
        char character = input.next().charAt(0);
        System.out.println(intero + ", " + decimale + ", " + stringaUtente + ", " + character);

        //puliamo la memoria dello scanner
        input.close();
    }
}
