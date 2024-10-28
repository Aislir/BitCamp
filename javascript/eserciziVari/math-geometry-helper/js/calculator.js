const display = document.getElementById("display");
var temp1 = 0;


//scrittura numeri a schermo
function appendNumber(input) {
    
    display.value += input;
}

//calcolo operazioni
function calculate() {

    //display.value = eval(display.value); 
    display.value = Function("return " + display.value)();
}

//pulizia display per nuovo calcolo
function clearDisplay() {
    
    display.value = "";
}