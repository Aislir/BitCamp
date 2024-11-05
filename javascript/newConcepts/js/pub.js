//simulazione database per il menu
var menu = [
    {nome: "Birra", prezzo: 5},
    {nome: "Panino", prezzo: 8},
    {nome: "Patatine", prezzo: 3}
];

//Array per gestione ordini
var ordini = [];

//funzione aggiornamento menu
function aggiornaMenu() {
    var menuItems = document.querySelector("#menu-items");
    menuItems.innerHTML = "";

    //popoliamo la tabella con for each
    //le doppie parentesi tonde dentro al forEach sono un paio per i parametri del for, l'altro per la funzione (in questo caso senza nome) con suoi parametri
    menu.forEach((articolo, index) => {  //articolo e' un nome provvisorio per rappresentare l'array menu. Index e' una variabile per rappresentare l'attuale indice all'interno dell'array
        var row = document.createElement("tr");

        row.innerHTML = `
            <td>${articolo.nome}</td>
            <td>${articolo.prezzo} €</td>
            <td><button onclick="rimuoviArticolo(${index})">Rimuovi</button></td>
            `;
        
        //aggiunta della riga alla tabella
        menuItems.appendChild(row);
    });
}

//funzione per rimuovere un articolo dalla tabella 
function rimuoviArticolo(index) {
    menu.splice(index, 1); //splice permette di rimuovere gli elementi. Index indica in quale riga si devono eliminare gli elementi, il secondo parametro indica quanti elementi eliminare su tale riga
    aggiornaMenu();
}

//funzione aggiungi articolo
function aggiungiArticolo() {
    var nome = document.querySelector("#item-name").value;
    var prezzo = parseFloat(document.querySelector("#item-price").value);

    //controllo verifica dati input
    if(nome && prezzo){ //sono veri entrambi se e' stato inserito qualcosa
        menu.push({nome, prezzo});
        aggiornaMenu();
        
        //ripuliamo i campi di input
        document.querySelector('#item-name').value = '';
        document.querySelector('#item-price').value = '';
    } else {
        alert('Inserisci nome e/o prezzo validi.');
    }
}

//funzione per aggiungere un nuovo ordine
function aggiungiOrdine() {

}

//funzione per aggiornare lista ordini
function aggiornaOrdini(){

}

aggiornaMenu();