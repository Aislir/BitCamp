console.log('Hello World!');

console.log('Hi Riky, this is your first js program on windows!');
/*
let answer = prompt("Please insert your name");
alert("Hi " + answer + "! Welcome to my website.");
*/

const div = document.createElement('div');
const para = document.createElement("p");

para.textContent = "Hello World!";
div.textContent = "Hello World!";


document.body.appendChild(div);
div.appendChild(para);

