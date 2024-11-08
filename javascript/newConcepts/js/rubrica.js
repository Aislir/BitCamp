var contatti = [];

function aggiornaContatti(){
    var table = document.querySelector("#contatti");
    table.innerHTML = "";  

    //popoliamo la tabella con for each
    //le doppie parentesi tonde dentro al forEach sono un paio per i parametri del for, l'altro per la funzione (in questo caso senza nome) con suoi parametri
    contatti.forEach((rubrica, index) => {  
        var row = document.createElement("tr");

        row.innerHTML = `
            <td>${rubrica.nome}</td>
            <td>${rubrica.cognome}</td>
            <td>${rubrica.numero}</td>
            <td><button onclick="rimuoviContatto(${index})">Rimuovi</button></td>
            <td><button onclick="modificaContatto(${index})">Modifica</button></td>
            `;
        
        //aggiunta della riga alla tabella
        table.appendChild(row);
    });
}

function aggiungiContatto() {
    var nome = document.querySelector("#nome-contatto").value;
    var cognome = document.querySelector("#cognome-contatto").value;
    var numero = document.querySelector("#numero-contatto").value;


    if(nome && cognome && numero){
        var counter = false;

        contatti.forEach((rubrica, index) => {
            if(rubrica.numero == numero){
                alert("Questo numero e' gia stato inserito!");
                counter = true;
            }
            
        });

        if(!counter){
            contatti.push({nome, cognome, numero});
            aggiornaContatti();
        }
        
        //ripuliamo i campi di input
        document.querySelector('#nome-contatto').value = '';
        document.querySelector("#cognome-contatto").value = '';
        document.querySelector('#numero-contatto').value = '';
    } else {
        alert('Inserisci nome, cognome e/o numero validi.');
    }
}



function rimuoviContatto(index){
    contatti.splice(index, 1);
    aggiornaContatti();
}

function modificaContatto(index){

    
    const bottoneModifica = document.querySelector("#tasto-modifica");

    //funzione
    bottoneModifica.onclick = function() {

        contatti[index].nome = inputNome.value;
        contatti[index].cognome = inputCognome.value;
        contatti[index].numero = inputNumero.value;

        document.querySelector('#nome-contatto').value = '';
        document.querySelector("#cognome-contatto").value = '';
        document.querySelector('#numero-contatto').value = '';

        bottoneModifica.style.display = "none";
        aggiornaContatti();

    };


    bottoneModifica.style.display = "block";
    
    
    var inputNome = document.querySelector("#nome-contatto");
    var inputCognome = document.querySelector("#cognome-contatto");
    var inputNumero = document.querySelector("#numero-contatto");

    inputNome.value += contatti[index].nome;
    inputCognome.value += contatti[index].cognome;
    inputNumero.value += contatti[index].numero;
}





