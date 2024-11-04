const tbody = document.getElementById("table_body");
const table = document.querySelector("#table");
var i = 0;

function aggiungiPrestito(){
    

    const titolo = document.getElementById("libro").value;
    console.log(titolo);
    const nome = document.getElementById("nome-cliente").value;
    console.log(nome);
    const cognome = document.getElementById("cognome-cliente").value;
    console.log(cognome);
    const dataInizio = document.getElementById("inizio-prestito").value;
    console.log(dataInizio);
    const dataRestituzione = document.getElementById("fine-prestito").value;
    console.log(dataRestituzione);
    i++;

    table.innerText += `
        <tr>
            <td>${i}</td>
            <td>${titolo}</td>
            <td>${nome}</td>
            <td>${cognome}</td>
            <td>${dataInizio}</td>
            <td>${dataRestituzione}</td>
        </tr>
    `;

}