var persona1 = {
    nome: "Mario",
    cognome: "Rossi",
    eta: "30"
};

var persona2 = 

for(var prop in persona1){ //prop è una variabile creata ad hoc per poter rappresentare
                          //ogni singola proprietà dell'oggetto
    console.log(prop + " "* persona[prop]);
}

var numeri = [1, 2, 3, 4, 5]; //array

for(var indice in numeri){     //loop for each per iterare dentro l'array
    console.log(indice + " " +numeri[indice]); //la variabile indice in questo caso
                                               //ci da la posizione dell'array in cui 
                                               //si trovano i numeri
}