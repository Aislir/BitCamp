function showName() {
    var name = document.getElementById("nome").value;
    console.log(name);
    var para = document.getElementById("userName");
    para.textContent = name;
}

var str = document.getElementById("risultato");

var risultato;

function sum(){
    var num1 = document.getElementById("number1").value;
    var num2 = document.getElementById("number2").value;    
    risultato = parseInt(num1) + parseInt(num2);
    str.textContent = risultato;
}

function diff() {
    var num1 = document.getElementById("number1").value;
    var num2 = document.getElementById("number2").value;    
    risultato = parseInt(num1) - parseInt(num2);
    str.textContent = risultato;
}

function mult() {
    var num1 = document.getElementById("number1").value;
    var num2 = document.getElementById("number2").value;    
    risultato = parseInt(num1) * parseInt(num2);
    str.textContent = risultato;
}

function division() {
    var num1 = document.getElementById("number1").value;
    var num2 = document.getElementById("number2").value;    
    risultato = parseInt(num1) / parseInt(num2);
    str.textContent = risultato;
}