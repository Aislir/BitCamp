var passwordSalvate = [];



function aggiungiPassword() {
    
    //associamo a delle variabili i campi di input
    var nomeServizio = document.querySelector('#nomeServizio').value;
    var nomeUtente = document.querySelector('#username').value;
    var password = document.querySelector('#password').value;


    var isPasswordOk = false;
    isPasswordOk = controlloPassword(password);

    if(isPasswordOk){
        passwordSalvate.push({nomeServizio, nomeUtente, password});
        aggiornaPassword();
    } else {
        alert("La password deve essere compresa da 8 a 12 caratteri e contenere almeno una lettera maiuscola, una minuscola, un numero ed un simbolo.");
    }


    //ripuliamo i campi di input
    document.querySelector('#nomeServizio').value = '';
    document.querySelector('#username').value = '';
    document.querySelector('#password').value = '';


}

function aggiornaPassword(){
    var tableBody = document.querySelector('#table-items');
    tableBody.innerHTML = '';

    passwordSalvate.forEach((oggetto, index) => {
        const row = document.createElement("tr");
        
        row.innerHTML = `
            <td>${oggetto.nomeServizio}</td>
            <td>${oggetto.nomeUtente}</td>
            <td>${oggetto.password}</td>
            <td><button onclick="modificaPassword(${index})">Modifica</button>
            <button onclick="rimuoviPassword(${index})">Rimuovi</button></td>
        `
        tableBody.appendChild(row);
    })


}

function rimuoviPassword(index){
    passwordSalvate.splice(index, 1);
    aggiornaPassword();

}

function modificaPassword(index){

    var bottoneModifica = document.querySelector('#tasto-modifica');
    var salvaBtn = document.querySelector('#salvaPassword');

    //rendo il bottone per confermare le modifiche visibile
    bottoneModifica.style.display = "block";
    salvaBtn.style.display = "none";

    //seleziono nuovamente i campi di input
    var inputServizio = document.querySelector("#nomeServizio");
    var inputUtente = document.querySelector("#username");
    var inputPassword = document.querySelector("#password");

    //aggiorno i campi di input con gli elementi dell'oggetto da modificare
    inputServizio.value += passwordSalvate[index].nomeServizio;
    inputUtente.value += passwordSalvate[index].nomeUtente;
    inputPassword.value += passwordSalvate[index].password;


    //funzione che viene lanciata quando il bottone "conferma modifiche" viene premuto
    bottoneModifica.onclick = function() {

        var isPasswordOkay = inputPassword.value;

        if(controlloPassword(isPasswordOkay)){

            //passo gli elementi dell'oggetto come valori ai campi di input
            passwordSalvate[index].nomeServizio = inputServizio.value;
            passwordSalvate[index].nomeUtente = inputUtente.value;
            passwordSalvate[index].password = inputPassword.value;
        } else {
            alert("La password deve essere compresa da 8 a 12 caratteri e contenere almeno una lettera maiuscola, una minuscola, un numero ed un simbolo.");
        }


        //pulisco nuovamente i campi di input
        document.querySelector('#nomeServizio').value = '';
        document.querySelector("#username").value = '';
        document.querySelector('#password').value = '';

        //rendo nuovamente il bottone non visibile
        bottoneModifica.style.display = "none";
        salvaBtn.style.display = "block";
        aggiornaPassword();

    };


}

function controlloPassword(password){

    //inizializzo booleano da ritornare come risultato del controllo
    var result = false;

    //inizializziamo le variabili da utilizzare per il controllo della password
    var maiuscolo = false;
    var minuscolo = false;
    var numero = false;
    var simbolo = false;
    var simboli = "[ `!@#$%^&*()_+-=[]{};':\\|,.<>/?~]";

    //controllo lunghezza password minima e massima
    if(password.length >= 8 && password.length <= 12){
        
        //for per ciclare ogni singolo carattere della password
        for(let i = 0; i < password.length; i++){
        
            //controllo presenza lettera minuscola
            if(password[i] >= "a" && password[i] <= "z"){
                minuscolo = true;
            }

            //controllo presenza lettera maiuscola
            if(password[i] >= "A" && password[i] <= "Z"){
                maiuscolo = true;
            }

            //controllo presenza numero
            if(password[i] >= "0" && password[i] <= "9"){
                numero = true;
            }

            //controllo presenza simboli
            for(let k = 0; k < simboli.length; k++){
                if(password[i] == simboli[k]){
                    simbolo = true;
                }
            }

        }
    }

    if(maiuscolo && minuscolo && numero && simbolo){
        result = true;
    }

    return result;
};

function generaPassword(){
    
    //inizializzazione della variabile della password generata randomicamente
    var passwordRandom = "";

    //array di stringhe con i caratteri selezionabili
    var charset = ["ABCDEFGHIJKLMNOPQRSTUVWXYZ", "abcdefghijklmnopqrstuvwxyz", "0123456789", "[ `!@#$%^&*()_+-=[]{};':\\|,.<>/?~]"]
    
    //primo loop per scegliere i primi 4 caratteri, 1 per ogni tipo
    for(let k = 0; k < charset.length; k++){

        passwordRandom += charset[k].charAt(Math.floor(Math.random() * charset[k].length));
    }

    //seleziono il select per trovare la lunghezza della password scelta dall'utente
    var sceltaLunghezza = document.querySelector("#passwordAutomatica").value;
    
    //loop per completamente password da scelta completamente randomica
    for(let i = 0; i < sceltaLunghezza - 4; i++){

        var randomChar = Math.floor(Math.random() * 4);
        passwordRandom += charset[randomChar].charAt(Math.floor(Math.random() * charset[randomChar].length));
        console.log(passwordRandom);
    }

    var campoPassword = document.querySelector("#password");
    campoPassword.value = passwordRandom;
};

function cercaServizio(){

    var riga = document.createElement("tr");
    var bodyTabella = document.querySelector("#table-items");
    var filtroUtente = document.querySelector("#filtraServizio").value;
    //const row = document.createElement("tr");
    bodyTabella.innerHTML = "";

    var counter = 0;
    passwordSalvate.forEach((elemento, indice) => {

        if(elemento.nomeServizio == filtroUtente){

            counter++;

            riga.innerHTML = `
            <td>${elemento.nomeServizio}</td>
            <td>${elemento.nomeUtente}</td>
            <td>${elemento.password}</td>
            <td><button onclick="modificaPassword(${indice})">Modifica</button>
            <button onclick="rimuoviPassword(${indice})">Rimuovi</button></td>
            `;

            bodyTabella.appendChild(riga);
        }

    });

    if(!counter){
        alert("Mi dispiace! Non siamo riusciti a trovare niente per il filtro impostato");
    }

    const resetBtn = document.querySelector('#resetTabella');
    resetBtn.style.display = 'block';


};


aggiornaPassword();