const inizioPartita = document.createElement("button"); //bottone inizio partita
const invioRisposta = document.createElement("button"); //bottone di invio risposta
const domanda = document.createElement("p");            //paragrafo domanda
const risultato = document.createElement("p");          //paragrafo risultato
const playerName = document.createElement('p');         //identificativo giocatore

//coriandoli per festeggiamento vittoria giocatore
const coriandoli = document.querySelector("#coriandoli");
const jsCoriandoli = new JSConfetti();

const vittoria = document.querySelector("#vittoria");

const mappa = document.getElementById("cacciaAlTesoro");
const player = document.getElementById("posizione_1");



inizioPartita.textContent = "Nuova partita";
invioRisposta.textContent = "Invio";

const input = document.createElement("input");          //casella per input risposte
input.type = 'text';
input.id = 'risposta';

const div = document.getElementById("domandaRisposta");
div.appendChild(inizioPartita); //inizialmente solo questo pulsante viene visualizzato
var counterDomande = 1;

//Il pulsante "inizioPartita" viene premuto
inizioPartita.addEventListener("click", nuovaPartita = () => {

    //rimozione del pulsante di inizio partita
    div.removeChild(inizioPartita);
    
    //inserimento del paragrafo di domanda, input di risposta e bottone di invio
    div.appendChild(domanda);
    domande(counterDomande);
    div.appendChild(input);
    div.appendChild(invioRisposta);

    //posizionamento giocatore per nuova partita
    player.style.left = "51%";
    player.style.top = "95%";

})  


function domande(counterDomande) {


    switch(counterDomande){

        case 1: 

            domanda.textContent = "Quanto fa 2 + 2?";
            break;

        case 2:

            domanda.textContent = "Quanti lati ha un triangolo?";
            break;

        case 3:

            domanda.textContent = "Quanto fa 17 * 3?";
            break;

        case 4: 
        
            domanda.textContent = "Dato un triangolo rettangolo i cui lati corti misurano 6 e 8, quanto misura l'ipotenusa?";
            break;

        case 5: 

            domanda.textContent = "Qual e' la media aritmetica dei numeri 4, 8 e 12?";
            break;

        case 6: 

            domanda.textContent = "Dato un rettangolo il cui perimetro misura 24cm ed il lato lungo 8cm, qual e' la sua area?";
            break;

        case 7: 

            domanda.textContent = "Data l'equazione 'x + 5 = 12', quanto vale x?";
            break;

        case 8:

            domanda.textContent = "Calcola l'area di un cerchio il cui raggio e' uguale a 7 (utilizzare π = 3,14)";
            break;
        
        case 9:

            domanda.textContent = "Data l'equazione '3(x - 2) + 4 = 2(x + 5) - 3', calcola il valore di x";
    }
}

//inizio controllo risposta
invioRisposta.addEventListener("click", checkRisposta = () => {
    
    var valoreRisposta = document.getElementById('risposta').value;
    //alert(valoreRisposta);

    switch(counterDomande) {

        case 1: 

            if(valoreRisposta == "4") {
                risultato.textContent = "Complimenti! Risposta esatta! Vai alla classe numero 4";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;

        case 2: 

            if(valoreRisposta == "3") {
                risultato.textContent = "Complimenti! Risposta esatta! Vai alla classe numero 8";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato); 
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;

        case 3: 
            if(valoreRisposta == "51") {
                risultato.textContent = "Complimenti! Risposta esatta! Vai alla classe numero 5";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato); 
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;

        case 4: 

            if(valoreRisposta == "10") {
                risultato.textContent = "Complimenti! Risposta esatta! Ti stai avvicinando al tesoro. Vai alla classe numero 3";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato); 
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;

        case 5: 
            
            if(valoreRisposta == "8") {
                risultato.textContent = "Complimenti! Risposta esatta! Vai alla classe numero 7";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato); 
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;

        case 6:

            if(valoreRisposta == "32") {
                risultato.textContent = "Complimenti! Risposta esatta! Wow, sei sempre piu' vicino! Vai alla classe numero 2";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato); 
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;

        case 7: 

            if(valoreRisposta == 7) {
                risultato.textContent = "Complimenti! Risposta esatta! Manca poco! Vai alla classe numero 6";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato); 
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;

        case 8: 

            if(valoreRisposta == "153,86") {
                risultato.textContent = "Complimenti! Risposta esatta! Ci sei quasi! Vai alla classe numero 1";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato); 
                playerPosition();
                counterDomande++;
                domande(counterDomande);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;
                
        case 9:

            if(valoreRisposta == "9") {
                //jsCoriandoli.addConfetti();
                risultato.textContent = "Complimenti! Risposta esatta! Hai vinto, hai trovato il tesoro!";
                risultato.style.color = "green";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
                playerPosition();

                //rimozione elementi per inizio nuova partita
                div.removeChild(domanda);
                div.removeChild(input);
                div.removeChild(invioRisposta);

                //preparazione per nuova partita
                counterDomande = 1;

                vittoria.style.display = "block";
                //div.appendChild(inizioPartita);
            } else {
                risultato.textContent = "Oh no! Risposta errata. Riprova!";
                risultato.style.color = "red";
                document.getElementById("risposta").value = "";
                div.appendChild(risultato);
            }
            break;
    }
})


//determinazione posizione giocatore
function playerPosition() {

    
    switch(counterDomande) {

        case 1:
            player.style.left = "78%";
            player.style.top = "62%";
            break;

        case 2: 
            player.style.top = "22%";
            
            break;

        case 3: 
            player.style.left = "23.5%";
            player.style.top = "42%";
            break;

        case 4: 
            player.style.left = "23.5%";
            player.style.top = "62%";
            break;

        case 5: 
            player.style.left = "23.5%";
            player.style.top = "22%";
            break;
        
        case 6: 
            player.style.left = "78%";
            player.style.top = "82%";
            break;
        
        case 7: 
            player.style.left = "78%";
            player.style.top = "42%";
            break;

        case 8: 
            player.style.left = "23.5%";
            player.style.top = "82%";
            break;

        case 9:
            player.style.left = "50%";
            player.style.top = "20%";
            break;
    }

}

function celebration() {
    jsCoriandoli.addConfetti();
    div.removeChild(risultato);
    div.appendChild(inizioPartita);
    vittoria.style.display = "none";
}