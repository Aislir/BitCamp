function calcolaTotale() {
    var carrello = document.getElementById("carrello");
    var totale = 0;
    var magliette = document.querySelectorAll('input[type="checkbox"]:checked'); //seleziona tutti gli input di tipo checkbox che hanno la spunta 'checked'
    var granTotale = document.getElementById("totale");

    carrello.textContent = ' ';

    for(let i = 0; i < magliette.length; i++){ //magliette.length indica quante spunte sono state selezionate
        var maglietta = magliette[i];
        var nomeMaglietta = maglietta.getAttribute('id');
        var prezzoMaglietta = maglietta.value;

        var li = document.createElement('li');
        li.textContent = nomeMaglietta + " - " + prezzoMaglietta + " euro.";
        carrello.appendChild(li);

        totale += parseInt(prezzoMaglietta);
    }

    granTotale.textContent = totale;
}