const form = document.querySelector("form");
const num = document.createElement("td");
const riga = document.createElement("tr");


function onSubmit(e) {
    e.preventDefault();

    const tbody = document.querySelector("tbody");

    const data = document.getElementById("data").value;
    const ora = document.getElementById("ora").value;

    alert(data +  ora);
    tbody.innerHTML += `
        <tr>
            <td>${data}</td>
            <td>${ora}</td>
        </tr>
    `;
}


form.addEventListener("submit", onSubmit);