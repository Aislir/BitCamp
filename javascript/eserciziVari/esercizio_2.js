//primo esercizio

let n1 = prompt('Inserisci un numero',  'numero');
let str1 = prompt('Inserisci una parola', 'parola');

let conc = 'Ecco cio che hai inserito: ' + n1 + ' ' + str1;

console.log(conc);
alert(conc);

//secondo esercizio

alert('adesso facciamo un gioco :)');

let n2 = prompt('Inserisci un numero',  'numero');
console.log("Il numero inserito e': " +n2);
let n3 = n1;

let temp = n2;
n2 = n3; 
n3 = temp;

alert("Ecco qui, adesso il tuo numero non e' piu' " +n3+ ", ma " +n2+ "!");
console.log("Ecco qui, adesso il tuo numero non e' piu' " +n3+ ", ma " +n2+ "!");
