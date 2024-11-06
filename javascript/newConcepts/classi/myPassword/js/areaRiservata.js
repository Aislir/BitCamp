var passwordSalvate = [];



function aggiungiPassword() {
    
    //associamo a delle variabili i campi di input
    var nomeServizio = document.querySelector('#nomeServizio').value;
    var nomeUtente = document.querySelector('#username').value;
    var password = document.querySelector('#password').value;


    var isPasswordOk = false;
    isPasswordOk.controlloPassword(password);

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

    //rendo il bottone per confermare le modifiche visibile
    bottoneModifica.style.display = "block";

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

        //passo gli elementi dell'oggetto come valori ai campi di input
        passwordSalvate[index].nomeServizio = inputServizio.value;
        passwordSalvate[index].nomeUtente = inputUtente.value;
        passwordSalvate[index].password = inputPassword.value;

        //pulisco nuovamente i campi di input
        document.querySelector('#nomeServizio').value = '';
        document.querySelector("#username").value = '';
        document.querySelector('#password').value = '';

        //rendo nuovamente il bottone non visibile
        bottoneModifica.style.display = "none";
        aggiornaPassword();

    };


}

function controlloPassword(password){

    //inizializziamo le variabili da utilizzare per il controllo della password
    var maiuscolo = false;
    var minuscolo = false;
    var numero = false;
    var simbolo = false;
    var simboli = 
    
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
        for(let k = 0; k)
    }
};


aggiornaPassword();