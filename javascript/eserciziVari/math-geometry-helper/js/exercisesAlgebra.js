

function calcolaPunteggioAlgebra() {

    var punteggioAlgebra = 0;
    
    //Verifica Esercizio 1
    const rispostaA1 = document.querySelector('input[name="esercizio1"]:checked');
    const rispostaCorrettaA1 = "2";
    const feedbackA1 = document.getElementById("punteggioAlg1");

    if (rispostaA1) {
        if (rispostaA1.value === rispostaCorrettaA1) {
            punteggioAlgebra++;
            feedbackA1.textContent = "Risposta Corretta!";
            feedbackA1.style.color = "green";
        } else {
            feedbackA1.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA1 + ".";
            feedbackA1.style.color = "red";
        }
    } else {
        feedbackA1.textContent = "Non hai inserito nessuna risposta!";
        feedbackA1.style.color = "red";
    }

    //Verifica Esercizio 2
    const rispostaA2 = document.querySelector('input[name="esercizio2"]').value;
    
    const rispostaCorrettaA2 = "4";
    const feedbackA2 = document.getElementById("punteggioAlg2");

    if (rispostaA2) {
        if (rispostaA2 === rispostaCorrettaA2) {
            punteggioAlgebra++;
            feedbackA2.textContent = "Risposta Corretta!";
            feedbackA2.style.color = "green";
        } else {
            feedbackA2.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA2 + ".";
            feedbackA2.style.color = "red";
        }
    } else {
        feedbackA2.textContent = "Non hai inserito nessuna risposta!";
        feedbackA2.style.color = "red";
    }

    //Verifica Esercizio 3
    const rispostaA3 = document.querySelector('input[name="esercizio3"]:checked');
    const rispostaCorrettaA3 = "6";
    const feedbackA3 = document.getElementById("punteggioAlg3");

    if (rispostaA3) {
        if (rispostaA3.value === rispostaCorrettaA3) {
            punteggioAlgebra++;
            feedbackA3.textContent = "Risposta Corretta!";
            feedbackA3.style.color = "green";
        } else {
            feedbackA3.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA3 + ".";
            feedbackA3.style.color = "red";
        }
    } else {
        feedbackA3.textContent = "Non hai inserito nessuna risposta!";
        feedbackA3.style.color = "red";
    }

    //Verifica Esercizio 4
    const rispostaA4 = document.querySelector('input[name="esercizio4"]').value;
    const rispostaCorrettaA4 = "3";
    const feedbackA4 = document.getElementById("punteggioAlg4");

    if (rispostaA4) {
        if (rispostaA4 === rispostaCorrettaA4) {
            punteggioAlgebra++;
            feedbackA4.textContent = "Risposta Corretta!";
            feedbackA4.style.color = "green";
        } else {
            feedbackA4.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA4 + ".";
            feedbackA4.style.color = "red";
        }
    } else {
        feedbackA4.textContent = "Non hai inserito nessuna risposta!";
        feedbackA4.style.color = "red";
    }

    //Verifica Esercizio 5
    const rispostaA5 = document.querySelector('input[name="esercizio5"]:checked');
    const rispostaCorrettaA5 = "3";
    const feedbackA5 = document.getElementById("punteggioAlg5");

    if (rispostaA5) {
        if (rispostaA5.value === rispostaCorrettaA5) {
            punteggioAlgebra++;
            feedbackA5.textContent = "Risposta Corretta!";
            feedbackA5.style.color = "green";
        } else {
            feedbackA5.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA5 + ".";
            feedbackA5.style.color = "red";
        }
    } else {
        feedbackA5.textContent = "Non hai inserito nessuna risposta!";
        feedbackA5.style.color = "red";
    }

    //Verifica Esercizio 6
    const rispostaA6 = document.querySelector('input[name="esercizio6"]').value;
    const rispostaCorrettaA6 = "4";
    const feedbackA6 = document.getElementById("punteggioAlg6");

    if (rispostaA6) {
        if (rispostaA6 === rispostaCorrettaA6) {
            punteggioAlgebra++;
            feedbackA6.textContent = "Risposta Corretta!";
            feedbackA6.style.color = "green";
        } else {
            feedbackA6.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA6 + ".";
            feedbackA6.style.color = "red";
        }
    } else {
        feedbackA6.textContent = "Non hai inserito nessuna risposta!";
        feedbackA6.style.color = "red";
    }

    //Verifica Esercizio 7
    const rispostaA7 = document.querySelector('input[name="esercizio7"]:checked');
    const rispostaCorrettaA7 = "3";
    const feedbackA7 = document.getElementById("punteggioAlg7");

    if (rispostaA7) {
        if (rispostaA7.value === rispostaCorrettaA7) {
            punteggioAlgebra++;
            feedbackA7.textContent = "Risposta Corretta!";
            feedbackA7.style.color = "green";
        } else {
            feedbackA7.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA7 + ".";
            feedbackA7.style.color = "red";
        }
    } else {
        feedbackA7.textContent = "Non hai inserito nessuna risposta!";
        feedbackA7.style.color = "red";
    }

    //Verifica Esercizio 8
    const rispostaA8 = document.querySelector('input[name="esercizio8"]').value;
    const rispostaCorrettaA8 = "2";
    const feedbackA8 = document.getElementById("punteggioAlg8");

    if (rispostaA8) {
        if (rispostaA8 === rispostaCorrettaA8) {
            punteggioAlgebra++;
            feedbackA8.textContent = "Risposta Corretta!";
            feedbackA8.style.color = "green";
        } else {
            feedbackA8.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA8 + ".";
            feedbackA8.style.color = "red";
        }
    } else {
        feedbackA8.textContent = "Non hai inserito nessuna risposta!";
        feedbackA8.style.color = "red";
    }

    //Verifica Esercizio 9
    const rispostaA9 = document.querySelector('input[name="esercizio9"]:checked');
    const rispostaCorrettaA9 = "2";
    const feedbackA9 = document.getElementById("punteggioAlg9");

    if (rispostaA9) {
        if (rispostaA9.value === rispostaCorrettaA9) {
            punteggioAlgebra++;
            feedbackA9.textContent = "Risposta Corretta!";
            feedbackA9.style.color = "green";
        } else {
            feedbackA9.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA9 + ".";
            feedbackA9.style.color = "red";
        }
    } else {
        feedbackA9.textContent = "Non hai inserito nessuna risposta!";
        feedbackA9.style.color = "red";
    }

    //Verifica Esercizio 10
    const rispostaA10 = document.querySelector('input[name="esercizio10"]').value;
    const rispostaCorrettaA10 = "10";
    const feedbackA10 = document.getElementById("punteggioAlg10");

    if (rispostaA10) {
        if (rispostaA10 === rispostaCorrettaA10) {
            punteggioAlgebra++;
            feedbackA10.textContent = "Risposta Corretta!";
            feedbackA10.style.color = "green";
        } else {
            feedbackA10.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA10 + ".";
            feedbackA10.style.color = "red";
        }
    } else {
        feedbackA10.textContent = "Non hai inserito nessuna risposta!";
        feedbackA10.style.color = "red";
    }

    //Verifica Esercizio 11
    const rispostaA11 = document.querySelector('input[name="esercizio11"]:checked');
    const rispostaCorrettaA11 = "3";
    const feedbackA11 = document.getElementById("punteggioAlg11");

    if (rispostaA11) {
        if (rispostaA11.value === rispostaCorrettaA11) {
            punteggioAlgebra++;
            feedbackA11.textContent = "Risposta Corretta!";
            feedbackA11.style.color = "green";
        } else {
            feedbackA11.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA11 + ".";
            feedbackA11.style.color = "red";
        }
    } else {
        feedbackA11.textContent = "Non hai inserito nessuna risposta!";
        feedbackA11.style.color = "red"; 
    }

    //Verifica Esercizio 12
    const rispostaA12 = document.querySelector('input[name="esercizio12"]').value;
    const rispostaCorrettaA12 = "5";
    const feedbackA12 = document.getElementById("punteggioAlg12");

    if (rispostaA12) {
        if (rispostaA12 === rispostaCorrettaA12) {
            punteggioAlgebra++;
            feedbackA12.textContent = "Risposta Corretta!";
            feedbackA12.style.color = "green";
        } else {
            feedbackA12.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA12 + ".";
            feedbackA12.style.color = "red";
        }
    } else {
        feedbackA12.textContent = "Non hai inserito nessuna risposta!";
        feedbackA12.style.color = "red";
    }

    //Verifica Esercizio 13
    const rispostaA13 = document.querySelector('input[name="esercizio13"]:checked');
    const rispostaCorrettaA13 = "3";
    const feedbackA13 = document.getElementById("punteggioAlg13");

    if (rispostaA13) {
        if (rispostaA13.value === rispostaCorrettaA13) {
            punteggioAlgebra++;
            feedbackA13.textContent = "Risposta Corretta!";
            feedbackA13.style.color = "green";
        } else {
            feedbackA13.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA13 + ".";
            feedbackA13.style.color = "red";
        }
    } else {
        feedbackA13.textContent = "Non hai inserito nessuna risposta!";
        feedbackA13.style.color = "red";
    }

    //Verifica Esercizio 14
    const rispostaA14 = document.querySelector('input[name="esercizio14"]').value;
    const rispostaCorrettaA14 = "7";
    const feedbackA14 = document.getElementById("punteggioAlg14");

    if (rispostaA14) {
        if (rispostaA14 === rispostaCorrettaA14) {
            punteggioAlgebra++;
            feedbackA14.textContent = "Risposta Corretta!";
            feedbackA14.style.color = "green";
        } else {
            feedbackA14.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA14 + ".";
            feedbackA14.style.color = "red";
        }
    } else {
        feedbackA14.textContent = "Non hai inserito nessuna risposta!";
        feedbackA14.style.color = "red";
    }

    //Verifica Esercizio 15
    const rispostaA15 = document.querySelector('input[name="esercizio15"]:checked');
    const rispostaCorrettaA15 = "2";
    const feedbackA15 = document.getElementById("punteggioAlg15");

    if (rispostaA15) {
        if (rispostaA15.value === rispostaCorrettaA15) {
            punteggioAlgebra++;
            feedbackA15.textContent = "Risposta Corretta!";
            feedbackA15.style.color = "green";
        } else {
            feedbackA15.textContent = "Risposta Sbagliata! La risposta corretta era " + rispostaCorrettaA15 + ".";
            feedbackA15.style.color = "red";
        }
    } else {
        feedbackA15.textContent = "Non hai inserito nessuna risposta!";
        feedbackA15.style.color = "red";
    }

    //Mostra il punteggio degli esercizi di algebra
    document.getElementById("punteggioAlgebra").textContent = punteggioAlgebra;

//Chiusura Funzione "calcolaPunteggioAlgebra()"

}