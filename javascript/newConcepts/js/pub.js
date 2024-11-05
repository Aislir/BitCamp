//simulazione database per il menu
var menu = [
    {nome: "Birra", prezzo: 5},
    {nome: "Panino", prezzo: 8},
    {nome: "Patatine", prezzo: 3}
];

//array globale per gestione di tutti gli ordini
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

    //creazione di un nuovo array per gestione singolo ordine
    var ordine = [];

    //riempimento del nuovo array mettendo all'interno gli elementi del menu ordinabili nonche' la quantita ordinata
    for(let i = 0; i < menu.length; i++){
        ordine.push({
            nome: menu[i].nome,
            prezzo: menu[i].prezzo,
            quantita: 0 //inizializzato a 0
        });
    }
    ordini.push(ordine);
    aggiornaOrdini();

}

//funzione per aggiornare lista ordini
function aggiornaOrdini(){

    var orderList = document.querySelector("#order-list");
    orderList.innerHTML = "";

    //loop all'interno dell'array ordini[] per riempimento in pagina
    for(var indexOrder = 0; indexOrder < ordini.length; indexOrder++){

        var ordine = ordini[indexOrder];

        var ordineDiv = document.createElement('div');
        ordineDiv.className = "ordine";

        var totale = 0;

        //questo for permette di stampare gli elementi contenuti in ogni singolo ordine, ovvero il nome dell'articolo, il suo prezzo, ed un input in cui inserire la quantita
        for(var articoloIndex = 0; articoloIndex < ordine.length; articoloIndex++){
            var articolo = ordine[articoloIndex];

            var articoloDiv = document.createElement('div');
            articoloDiv.innerHTML = `<strong>${articolo.nome}:</strong> ${articolo.prezzo} € x <input type="number" value="${articolo.quantita}" min="0" onchange="aggiornaQuantita(${indexOrder}, ${articoloIndex}, this.value)">`;
            //onchange permette di aggiornare il prezzo ogni volta che viene modificata la quantita di ogni singolo articolo all'interno di un ordine
            ordineDiv.appendChild(articoloDiv);

            totale += articolo.prezzo * articolo.quantita;

        }

        //fuori dal for degli articoli ma dentro il for degli ordini
        ordineDiv.innerHTML += `<p><strong>Totale:</strong> ${totale} €</p>`;
        orderList.appendChild(ordineDiv);
    }
}

function aggiornaQuantita(indexOrder, articoloIndex, nuovaQuantita){
    ordini[indexOrder][articoloIndex].quantita = parseInt(nuovaQuantita);

    aggiornaOrdini();
}

aggiornaMenu();