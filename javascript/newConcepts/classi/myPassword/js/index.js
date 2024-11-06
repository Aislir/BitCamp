var utenti = [
    {nomeUtente: 'Mario', passwordUtente: 'Admin'},
    {nomeUtente: 'Luigi', passwordUtente: 'Admin'},
    {nomeUtente: 'Wario', passwordUtente: 'Admin'},
    {nomeUtente: 'Waluigi', passwordUtente: 'Admin'}
];


function login(){

    //prendiamo i valori di input
    const userName = document.querySelector('#username').value;
    const userPassword = document.querySelector('#password').value;

    var isFound = false;

    for(var i in utenti){
        if((utenti[i].nomeUtente === userName) && (utenti[i].passwordUtente === userPassword)){
            isFound = true;
            break;
        }
    
    }

    if(isFound){
        window.open('areaRiservata.html', '_blank');
    } else {
        alert('Nessun utente registrato con questo nome e/o password');
    }

}
