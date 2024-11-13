package base;

import java.util.ArrayList;

public class ArrayListEx {

    public static void main(String[] args) {

        //Dichiarazione di un istanza di ArrayList
        ArrayList<Integer> numeriInt = new ArrayList<>();

        //aggiunta elementi all'ArrayList
        numeriInt.add(5);
        numeriInt.add(10);
        numeriInt.add(15);

        //Accesso ai singoli elementi all'interno dell'arraylist
        int num1 = numeriInt.get(0);
        System.out.println(num1 + (numeriInt.get(1))); //fa la somma tra i 2 elementi
        System.out.println(num1);
        System.out.println(numeriInt.get(1)); //stampo direttamente l'elemento all'interno
        //dell'arrayList senza passare il valore ad una variabile

        numeriInt.remove(1); //rimuove 10 ---> adesso 15 e' all'indice 1

        System.out.println(numeriInt.get(1));

        //iterazione in arraylist con for classico
        for (int i = 0; i < numeriInt.size(); i++){
            System.out.print(numeriInt.get(i) + " ");
        }

        System.out.println();

        //iterazione con foreach
        for (Integer numero : numeriInt) { //numero e' una variabile oggetto di tipo Int creata
            System.out.print(numero + " ");    //nel foreach per assegnargli l'attuale elemento
                                            //iterato all'interno dell'arrayList
        }

        System.out.println();

        boolean isItContained = numeriInt.contains(5); //contains itera all'interno dell'arrayList
        //guarda se il parametro inserito c'e' all'interno dell'arrayList e restituisce un booleano
        System.out.println("Nella lista e' presente il numero 5? "+isItContained);

        System.out.println();

        //dichiarazione di un ArrayList di tipo String
        ArrayList<String> arrayString = new ArrayList<>();

        arrayString.add("Hello");
        arrayString.add("World");
        arrayString.add("Programmatori");
        arrayString.add("Java");
        arrayString.add("World");

        arrayString.remove("World"); //e' possibile non dare solo indici, ma anche cio' che puo'
        //essere contenuto all'interno dell'arrayList. "remove" rimuove SOLO la prima istanza che
        //trova all'interno dell'arrayList.
        //Se viene passato come parametro qualcosa che non c'e' all'interno dell'AL, non viene rimosso niente
        System.out.println();

        for (String parola : arrayString){
            System.out.println(parola);
        }
        System.out.println();
        System.out.println("La parola Java e' presente? " + arrayString.contains("Java"));
    }
}
