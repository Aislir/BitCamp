function calcolaQuadrato() {
    //Creo la variabile per prendere il valore dell'input
    const lato = parseFloat(document.getElementById("latoQuadrato").value);
    //Pulisco i div dei 2 risultati e degli errori
    clearResults("risultatoAreaQuadrato", "risultatoPerimetroQuadrato");
    clearErrorMessages("erroreLatoQuadrato");
    //Condizione per gestire l'inserimento di un valore NON valido
    if (isNaN(lato) || lato <= 0) {
        showError("erroreLatoQuadrato", "Inserisci un numero valido maggiore di zero.");
        return;
    }
    //Creo le variabili per applicare le formule
    const area = lato * lato;
    const perimetro = 4 * lato;
    //Mando in output i risultati
    document.getElementById("risultatoAreaQuadrato").innerHTML = `Area: ${area.toFixed(2)} cm<sup>2</sup>`;
    document.getElementById("risultatoPerimetroQuadrato").innerHTML = `Perimetro: ${perimetro.toFixed(2)} cm`;
}

function calcolaRettangolo() {
    //Creo le variabili per prendere il valore dell'input
    const base = parseFloat(document.getElementById("baseRettangolo").value);
    const altezza = parseFloat(document.getElementById("altezzaRettangolo").value);
    //Pulisco i div dei 2 risultati e degli errori
    clearResults("risultatoAreaRettangolo", "risultatoPerimetroRettangolo");
    clearErrorMessages("erroreBaseRettangolo", "erroreAltezzaRettangolo");
    //Condizione per gestire l'inserimento di un valore NON valido
    if (isNaN(base) || base <= 0 || isNaN(altezza) || altezza <= 0) {
        if (isNaN(base) || base <= 0) {
            showError("erroreBaseRettangolo", "Inserisci un numero valido maggiore di zero.");
        }
        if (isNaN(altezza) || altezza <= 0) {
            showError("erroreAltezzaRettangolo", "Inserisci un numero valido maggiore di zero.");
        }
        return;
    }
    //Creo le variabili per applicare le formule
    const area = base * altezza;
    const perimetro = 2 * (base + altezza);
    //Mando in output i risultati
    document.getElementById("risultatoAreaRettangolo").innerHTML = `Area: ${area.toFixed(2)} cm<sup>2</sup>`;
    document.getElementById("risultatoPerimetroRettangolo").innerHTML = `Perimetro: ${perimetro.toFixed(2)} cm`;
}

function calcolaTriangolo() {
    //Creo le variabili per prendere i valori degli input
    const lato1 = parseFloat(document.getElementById("lato1Triangolo").value);
    const lato2 = parseFloat(document.getElementById("lato2Triangolo").value);
    const lato3 = parseFloat(document.getElementById("lato3Triangolo").value);
    //Pulisco i div dei 2 risultati e degli errori
    clearResults("risultatoAreaTriangolo", "risultatoPerimetroTriangolo");
    clearErrorMessages("erroreLato1Triangolo", "erroreLato2Triangolo", "erroreLato3Triangolo");
    //Condizione per gestire l'inserimento di un valore NON valido
    if (isNaN(lato1) || lato1 <= 0 || isNaN(lato2) || lato2 <= 0 || isNaN(lato3) || lato3 <= 0) {
        if (isNaN(lato1) || lato1 <= 0) {
            showError("erroreLato1Triangolo", "Inserisci un numero valido maggiore di zero.");
        }
        if (isNaN(lato2) || lato2 <= 0) {
            showError("erroreLato2Triangolo", "Inserisci un numero valido maggiore di zero.");
        }
        if (isNaN(lato3) || lato3 <= 0) {
            showError("erroreLato3Triangolo", "Inserisci un numero valido maggiore di zero.");
        }
        return;
    }
    //Creo le variabili per applicare le formule
    const perimetro = lato1 + lato2 + lato3;
    const s = perimetro / 2;
    const area = Math.sqrt(s * (s - lato1) * (s - lato2) * (s - lato3));
    //Mando in output i risultati
    document.getElementById("risultatoAreaTriangolo").innerHTML = `Area: ${area.toFixed(2)} cm<sup>2</sup>`;
    document.getElementById("risultatoPerimetroTriangolo").innerHTML = `Perimetro: ${perimetro.toFixed(2)} cm`;
}

function calcolaCerchio() {
    //Creo la variabile per prendere il valore dell'input
    const raggio = parseFloat(document.getElementById("raggio").value);
    //Pulisco i div dei 2 risultati e degli errori
    clearResults("risultatoAreaCerchio", "risultatoCirconferenzaCerchio");
    clearErrorMessages("erroreRaggio");
    //Condizione per gestire l'inserimento di un valore NON valido
    if (isNaN(raggio) || raggio <= 0) {
        showError("erroreRaggio", "Inserisci un numero valido maggiore di zero.");
        return;
    }
    //Creo le variabili per applicare le formule
    const area = Math.PI * raggio * raggio;
    const circonferenza = 2 * Math.PI * raggio;
    //Mando in output i risultati
    document.getElementById("risultatoAreaCerchio").innerHTML = `Area: ${area.toFixed(2)} cm<sup>2</sup>`;
    document.getElementById("risultatoCirconferenzaCerchio").innerHTML = `Circonferenza: ${circonferenza.toFixed(2)} cm`;
}

function calcolaTrapezio() {
    //Creo le variabili per prendere i valori degli input
    const baseMaggiore = parseFloat(document.getElementById("baseMaggiore").value);
    const baseMinore = parseFloat(document.getElementById("baseMinore").value);
    const altezza = parseFloat(document.getElementById("altezzaTrapezio").value);
    //Pulisco i div dei 2 risultati e degli errori
    clearResults("risultatoAreaTrapezio", "risultatoPerimetroTrapezio");
    clearErrorMessages("erroreBaseMaggiore", "erroreBaseMinore", "erroreAltezzaTrapezio");
    //Condizione per gestire l'inserimento di un valore NON valido
    if (isNaN(baseMaggiore) || baseMaggiore <= 0 || isNaN(baseMinore) || baseMinore <= 0 || isNaN(altezza) || altezza <= 0) {
        if (isNaN(baseMaggiore) || baseMaggiore <= 0) {
            showError("erroreBaseMaggiore", "Inserisci un numero valido maggiore di zero.");
        }
        if (isNaN(baseMinore) || baseMinore <= 0) {
            showError("erroreBaseMinore", "Inserisci un numero valido maggiore di zero.");
        }
        if (isNaN(altezza) || altezza <= 0) {
            showError("erroreAltezzaTrapezio", "Inserisci un numero valido maggiore di zero.");
        }
        return;
    }
    //Creo le variabili per applicare le formule
    const area = ((baseMaggiore + baseMinore) / 2) * altezza;
    const perimetro = baseMaggiore + baseMinore + (2 * Math.sqrt((altezza ** 2) + ((baseMaggiore - baseMinore) ** 2) / 4));
    //Mando in output i risultati
    document.getElementById("risultatoAreaTrapezio").innerHTML = `Area: ${area.toFixed(2)} cm<sup>2</sup>`;
    document.getElementById("risultatoPerimetroTrapezio").innerHTML = `Perimetro: ${perimetro.toFixed(2)} cm`;
}

function calcolaEllisse() {
    //Creo le variabili per prendere i valori degli input
    const semiasseMaggiore = parseFloat(document.getElementById("semiAsseMaggiore").value);
    const semiasseMinore = parseFloat(document.getElementById("semiAsseMinore").value);
    //Pulisco i div dei 2 risultati e degli errori
    clearResults("risultatoAreaEllisse", "risultatoPerimetroEllisse");
    clearErrorMessages("erroreSemiAsseMaggiore", "erroreSemiAsseMinore");
    //Condizione per gestire l'inserimento di un valore NON valido
    if (isNaN(semiasseMaggiore) || semiasseMaggiore <= 0 || isNaN(semiasseMinore) || semiasseMinore <= 0) {
        if (isNaN(semiasseMaggiore) || semiasseMaggiore <= 0) {
            showError("erroreSemiasseMaggiore", "Inserisci un numero valido maggiore di zero.");
        }
        if (isNaN(semiasseMinore) || semiasseMinore <= 0) {
            showError("erroreSemiasseMinore", "Inserisci un numero valido maggiore di zero.");
        }
        return;
    }
    //Creo le variabili per applicare le formule
    const area = Math.PI * semiasseMaggiore * semiasseMinore;
    const perimetro = Math.PI * (3 * (semiasseMaggiore + semiasseMinore) - Math.sqrt((3 * semiasseMaggiore + semiasseMinore) * (semiasseMaggiore + 3 * semiasseMinore)));
    //Mando in output i risultati
    document.getElementById("risultatoAreaEllisse").innerHTML = `Area: ${area.toFixed(2)} cm<sup>2</sup>`;
    document.getElementById("risultatoPerimetroEllisse").innerHTML = `Perimetro: ${perimetro.toFixed(2)} cm`;
}

// Funzione per mostrare i messaggi di errore
function showError(id, message) {
    document.getElementById(id).innerText = message;
}

// Funzione per pulire i risultati
function clearResults(...ids) {
    ids.forEach(id => {
        document.getElementById(id).innerHTML = '';
    });
}

// Funzione per pulire i messaggi di errore
function clearErrorMessages(...ids) {
    ids.forEach(id => {
        document.getElementById(id).innerText = '';
    });
}
