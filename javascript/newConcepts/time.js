function aggiornaOra() {
    //crea istanza di Date
    var oraCorrente = new Date();

    //ottiene informazioni sull'ora corrente
    var ore = oraCorrente.getHours();
    var minuti = oraCorrente.getMinutes();
    var secondi = oraCorrente.getSeconds();

    //formattiamo l'ora
    //var oraDigitale = ore + ":" + minuti + ":" + secondi;
    var oraDigitale = ((ore < 10) ? "0" : "") + ore + ":" + ((minuti < 10) ? "0" : "") + minuti + ":" + ((secondi < 10) ? "0" : "") + secondi;
                                
    //stampiamo l'ora sul tag con id ora
    document.getElementById("ora").innerHTML = oraDigitale;
}

setInterval(aggiornaOra, 1000);
//aggiornaOra();