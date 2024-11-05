var giocatore = {
    nome: "Eroe",
    salute: 100,
    attacco: 10,
    punteggio: 0,
    monete: 0
};

//MOSTRI DISPONIBILI
var mostri = [
    {nome: "Goblin", salute: 30, attacco: 8}, 
    {nome: "Orco", salute: 45, attacco: 12},
    {nome: "Drago", salute: 60, attacco: 15}
];

//SCELTA RANDOMICA NEMICO
var nemicoAttuale = mostri[parseInt(Math.random() * mostri.length)];

//AGGIORNAMENTO INTERFACCIA
function aggiornaInterfaccia() {
    document.getElementById("player-name").textContent = giocatore.nome;
    document.getElementById("player-health").textContent = giocatore.salute;
    document.getElementById("player-attack").textContent = giocatore.attacco;
    document.getElementById("player-coins").textContent = giocatore.monete;
    document.getElementById("player-score").textContent = giocatore.punteggio;

    document.getElementById("enemy-name").textContent = nemicoAttuale.nome;
    document.getElementById("enemy-health").textContent = nemicoAttuale.salute;
    document.getElementById("enemy-attack").textContent = nemicoAttuale.attacco;
}

//GESTIONE ATTACCHI
function attacca() {
    //il giocatore attacca il nemico
    nemicoAttuale.salute -= giocatore.attacco;
    if(nemicoAttuale.salute > 0){
        giocatore.salute -= nemicoAttuale.attacco;
        if(giocatore.salute <= 0){
            giocatore.salute = 0;
            document.getElementById("message").textContent = "Game Over! Il nemico ti ha sconfitto!";
        } else { document.getElementById("message").textContent = "Al nemico rimane " + nemicoAttuale.salute + " salute!";
            document.getElementById("message").textContent = "Il nemico ti ha attaccato! Adesso hai " +giocatore.salute + " salute!";
        }
    } else {document.getElementById("message").textContent = "Complimenti! Hai sconfitto il nemico!";
            giocatore.punteggio++;
            ottieniRicompensa();
    }

    aggiornaInterfaccia();
}

//cambia nemico
function cambiaNemico() {
    nemicoAttuale = mostri[parseInt(Math.random() * mostri.length)];
    document.getElementById("message").textContent = "Un nuovo nemico e' apparso: " +nemicoAttuale.nome + "!";
}

function ottieniRicompensa(){
    var random = Math.random();
    if(random < 0.5) {
        var recuperoSalute = parseInt(Math.random() * 10) + 10;
        giocatore.salute += recuperoSalute;
        document.getElementById("message").textContent = "Hai recuperato " +recuperoSalute+ " punti salute.";

    } else {
        var moneteGuadagnate = parseInt(Math.random() * 5) + 1;
        giocatore.monete += moneteGuadagnate;
        document.getElementById("message").textContent = "Hai guadagnato " +moneteGuadagnate+ " monete.";

    }
}

document.getElementById("attack-button").addEventListener("click", attacca);
document.getElementById("change-enemy").addEventListener("click", cambiaNemico);