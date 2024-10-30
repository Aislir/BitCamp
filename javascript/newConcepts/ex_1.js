
//COSTRUTTO DO WHILE

let i = 0;

do { //entra all'interno del while almeno una volta, prima di verificare se 
    //la condizione del while sia vera
    let isTrue = 5 > 7;
    console.log(isTrue);

    
    i++;

} while(i < 10);


//GENERAZIONE DI NUMERI CASUALI

let numeroRandom1 = Math.random(); //random restituisce di base un numero compreso
                                  //tra 0 e 1
console.log(numeroRandom1);

let numeroRandom2 = Math.random() * 100; //moltiplicando per 100 restituisce un numero
                                         //compreso tra 1 e 100;

console.log(numeroRandom2);

//COMBINAZIONE DI DO WHILE E RANDOM PER SELEZIONARE SOLO NUMERI PARI


do {
    var numeroRandom3 = Math.random() * 10; //numero compreso tra 0 e 10
    var firstInt = parseInt(numeroRandom3); //seleziono solo il primo numero di random
    if((firstInt % 2) === 0){               //controllo se il numero sia pari
        var outOfWhile = true;
    } else { outOfWhile = false;}
    var counter = 0;
    counter++;
    console.log(firstInt);
    console.log(outOfWhile);
    console.log("Il while ha ciclato "+counter+ " volte");
} while(!outOfWhile);



