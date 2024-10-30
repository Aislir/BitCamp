

function calcolaPunteggioGeometria() {

    var punteggioGeometria = 0;

    //Verifica Esercizio 1
    const rispostaG1 = document.querySelector('input[name="esercizioG1"]:checked');
    
    const rispostaCorrettaG1 = "15";
    const feedbackG1 = document.getElementById("punteggioGeom1");

    if (rispostaG1) {
        if (rispostaG1.value === rispostaCorrettaG1) {
            punteggioGeometria++;
            feedbackG1.textContent = "Risposta Corretta!";
            feedbackG1.style.color = "green";
        } else {
            feedbackG1.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG1 + " cm².";
            feedbackG1.style.color = "red";
        }
    } else {
        feedbackG1.textContent = "Non hai inserito nessuna risposta!";
        feedbackG1.style.color = "red";
    }

    //Verifica Esercizio 2
    const rispostaG2 = document.querySelector('input[name="esercizioG2"]').value;
    const rispostaCorrettaG2 = "16";
    const feedbackG2 = document.getElementById("punteggioGeom2");

    if (rispostaG2) {
        if (rispostaG2 === rispostaCorrettaG2) {
            punteggioGeometria++;
            feedbackG2.textContent = "Risposta Corretta!";
            feedbackG2.style.color = "green";
        } else {
            feedbackG2.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG2 + " cm.";
            feedbackG2.style.color = "red";
        }
    } else {
        feedbackG2.textContent = "Non hai inserito nessuna risposta!";
        feedbackG2.style.color = "red";
    }

    //Verifica Esercizio 3
    const rispostaG3 = document.querySelector('input[name="esercizioG3"]:checked');
    const rispostaCorrettaG3 = "12.56";
    const feedbackG3 = document.getElementById("punteggioGeom3");

    if (rispostaG3) {
        if (rispostaG3.value === rispostaCorrettaG3) {
            punteggioGeometria++;
            feedbackG3.textContent = "Risposta Corretta!";
            feedbackG3.style.color = "green";
        } else {
            feedbackG3.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG3 + " cm².";
            feedbackG3.style.color = "red";
        }
    } else {
        feedbackG3.textContent = "Non hai inserito nessuna risposta!";
        feedbackG3.style.color = "red";
    }

    //Verifica Esercizio 4
    const rispostaG4 = document.querySelector('input[name="esercizioG4"]').value;
    const rispostaCorrettaG4 = "5";
    const feedbackG4 = document.getElementById("punteggioGeom4");

    if (rispostaG4) {
        if (rispostaG4 === rispostaCorrettaG4) {
            punteggioGeometria++;
            feedbackG4.textContent = "Risposta Corretta!";
            feedbackG4.style.color = "green";
        } else {
            feedbackG4.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG4 + " cm.";
            feedbackG4.style.color = "red";
        }
    } else {
        feedbackG4.textContent = "Non hai inserito nessuna risposta!";
        feedbackG4.style.color = "red";
    }

    //Verifica Esercizio 5
    const rispostaG5 = document.querySelector('input[name="esercizioG5"]:checked');
    const rispostaCorrettaG5 = "12";
    const feedbackG5 = document.getElementById("punteggioGeom5");

    if (rispostaG5) {
        if (rispostaG5.value === rispostaCorrettaG5) {
            punteggioGeometria++;
            feedbackG5.textContent = "Risposta Corretta!";
            feedbackG5.style.color = "green";
        } else {
            feedbackG5.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG5 + " cm².";
            feedbackG5.style.color = "red";
        }
    } else {
        feedbackG5.textContent = "Non hai inserito nessuna risposta!";
        feedbackG5.style.color = "red";
    }

    //Verifica Esercizio 6
    const rispostaG6 = document.querySelector('input[name="esercizioG6"]').value;
    const rispostaCorrettaG6 = "8";
    const feedbackG6 = document.getElementById("punteggioGeom6");

    if (rispostaG6) {
        if (rispostaG6 === rispostaCorrettaG6) {
            punteggioGeometria++;
            feedbackG6.textContent = "Risposta Corretta!";
            feedbackG6.style.color = "green";
        } else {
            feedbackG6.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG6 + " cm³.";
            feedbackG6.style.color = "red";
        }
    } else {
        feedbackG6.textContent = "Non hai inserito nessuna risposta!";
        feedbackG6.style.color = "red";
    }

    //Verifica Esercizio 7
    const rispostaG7 = document.querySelector('input[name="esercizioG7"]:checked');
    const rispostaCorrettaG7 = "12";
    const feedbackG7 = document.getElementById("punteggioGeom7");

    if (rispostaG7) {
        if (rispostaG7.value === rispostaCorrettaG7) {
            punteggioGeometria++;
            feedbackG7.textContent = "Risposta Corretta!";
            feedbackG7.style.color = "green";
        } else {
            feedbackG7.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG7 + " cm.";
            feedbackG7.style.color = "red";
        }
    } else {
        feedbackG7.textContent = "Non hai inserito nessuna risposta!";
        feedbackG7.style.color = "red";
    }

    //Verifica Esercizio 8
    const rispostaG8 = document.querySelector('input[name="esercizioG8"]').value;
    const rispostaCorrettaG8 = "16";
    const feedbackG8 = document.getElementById("punteggioGeom8");

    if (rispostaG8) {
        if (rispostaG8 === rispostaCorrettaG8) {
            punteggioGeometria++;
            feedbackG8.textContent = "Risposta Corretta!";
            feedbackG8.style.color = "green";
        } else {
            feedbackG8.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG8 + " cm².";
            feedbackG8.style.color = "red";
        }
    } else {
        feedbackG8.textContent = "Non hai inserito nessuna risposta!";
        feedbackG8.style.color = "red";
    }

    //Verifica Esercizio 9
    const rispostaG9 = document.querySelector('input[name="esercizioG9"]:checked');
    const rispostaCorrettaG9 = "87,96";
    const feedbackG9 = document.getElementById("punteggioGeom9");

    if (rispostaG9) {
        if (rispostaG9.value === rispostaCorrettaG9) {
            punteggioGeometria++;
            feedbackG9.textContent = "Risposta Corretta!";
            feedbackG9.style.color = "green";
        } else {
            feedbackG9.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG9 + " cm³.";
            feedbackG9.style.color = "red";
        }
    } else {
        feedbackG9.textContent = "Non hai inserito nessuna risposta!";
        feedbackG9.style.color = "red";
    }

    //Verifica Esercizio 10
    const rispostaG10 = document.querySelector('input[name="esercizioG10"]').value;
    const rispostaCorrettaG10 = "9";
    const feedbackG10 = document.getElementById("punteggioGeom10");

    if (rispostaG10) {
        if (rispostaG10 === rispostaCorrettaG10) {
            punteggioGeometria++;
            feedbackG10.textContent = "Risposta Corretta!";
            feedbackG10.style.color = "green";
        } else {
            feedbackG10.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG10 + " cm².";
            feedbackG10.style.color = "red";
        }
    } else {
        feedbackG10.textContent = "Non hai inserito nessuna risposta!";
        feedbackG10.style.color = "red";
    }

    //Verifica Esercizio 11
    const rispostaG11 = document.querySelector('input[name="esercizioG11"]:checked');
    const rispostaCorrettaG11 = "22";
    const feedbackG11 = document.getElementById("punteggioGeom11");

    if (rispostaG11) {
        if (rispostaG11.value === rispostaCorrettaG11) {
            punteggioGeometria++;
            feedbackG11.textContent = "Risposta Corretta!";
            feedbackG11.style.color = "green";
        } else {
            feedbackG11.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG11 + " cm.";
            feedbackG11.style.color = "red";
        }
    } else {
        feedbackG11.textContent = "Non hai inserito nessuna risposta!";
        feedbackG11.style.color = "red";
    }

    //Verifica Esercizio 12
    const rispostaG12 = document.querySelector('input[name="esercizioG12"]').value;
    const rispostaCorrettaG12 = "6";
    const feedbackG12 = document.getElementById("punteggioGeom12");

    if (rispostaG12) {
        if (rispostaG12 === rispostaCorrettaG12) {
            punteggioGeometria++;
            feedbackG12.textContent = "Risposta Corretta!";
            feedbackG12.style.color = "green";
        } else {
            feedbackG12.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG12 + " cm.";
            feedbackG12.style.color = "red";
        }
    } else {
        feedbackG12.textContent = "Non hai inserito nessuna risposta!";
        feedbackG12.style.color = "red";
    }

    //Verifica Esercizio 13
    const rispostaG13 = document.querySelector('input[name="esercizioG13"]:checked');
    const rispostaCorrettaG13 = "24";
    const feedbackG13 = document.getElementById("punteggioGeom13");

    if (rispostaG13) {
        if (rispostaG13.value === rispostaCorrettaG13) {
            punteggioGeometria++;
            feedbackG13.textContent = "Risposta Corretta!";
            feedbackG13.style.color = "green";
        } else {
            feedbackG13.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG13 + " cm.";
            feedbackG13.style.color = "red";
        }
    } else {
        feedbackG13.textContent = "Non hai inserito nessuna risposta!";
        feedbackG13.style.color = "red";
    }

    //Verifica Esercizio 14
    const rispostaG14 = document.querySelector('input[name="esercizioG14"]').value;
    const rispostaCorrettaG14 = "6";
    const feedbackG14 = document.getElementById("punteggioGeom14");

    if (rispostaG14) {
        if (rispostaG14 === rispostaCorrettaG14) {
            punteggioGeometria++;
            feedbackG14.textContent = "Risposta Corretta!";
            feedbackG14.style.color = "green";
        } else {
            feedbackG14.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG14 + " cm².";
            feedbackG14.style.color = "red";
        }
    } else {
        feedbackG14.textContent = "Non hai inserito nessuna risposta!";
        feedbackG14.style.color = "red";
    }
    
    //Verifica Esercizio 15
    const rispostaG15 = document.querySelector('input[name="esercizioG15"]:checked');
    const rispostaCorrettaG15 = "18.84";
    const feedbackG15 = document.getElementById("punteggioGeom15");

    if (rispostaG15) {
        if (rispostaG15.value === rispostaCorrettaG15) {
            punteggioGeometria++;
            feedbackG15.textContent = "Risposta Corretta!";
            feedbackG15.style.color = "green";
        } else {
            feedbackG15.textContent = "Risposta Sbagliata! La risposta corretta e' " + rispostaCorrettaG15 + " cm.";
            feedbackG15.style.color = "red";
        }
    } else {
        feedbackG15.textContent = "Non hai inserito nessuna risposta!";
        feedbackG15.style.color = "red";
    }

    
    //Mostra il punteggio degli esercizi di Geometria
    document.getElementById("punteggioGeometria").textContent = punteggioGeometria;

//Chiusura Funzione "calcolaPunteggioGeometria()"

}