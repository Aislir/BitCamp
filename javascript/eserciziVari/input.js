function checkInfo() {
    var email = document.getElementById("email").value;
    var eta = document.getElementById("eta").value;
    var isAnEmail = false;
    for(let i = 0; i < email.length; i++){
        if(email.charAt[i] == '@'){
            isAnEmail = true;
        }
    }

    if((email === "" || isAnEmail == false) || eta === ""){
        alert("Invalid email or age");
    } else if(eta < 18) {
        alert("You shall not pass");
    } else {
        alert("Welcome to our website!");
    }
}