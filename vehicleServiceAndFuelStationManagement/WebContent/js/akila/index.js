const sighUpButton = document.getElementById("signUp");
const sighInButton = document.getElementById("signIn");
const container = document.getElementById("back-container");

sighUpButton.addEventListener('click',() => container.classList.add('right-panel-active'));
sighInButton.addEventListener('click',() => container.classList.remove('right-panel-active'));


var slideIndex = 0;
slideShow();
// check();

function slideShow() {
  var i;
  var slides = document.getElementsByClassName("slide");
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {
      slideIndex = 1
    }    
  
  slides[slideIndex-1].style.display = "block";  
  setTimeout(slideShow, 5000); // Change image every 2 seconds
}

function check(){
  // alert("akila");
  var username = document.getElementById('username').value;
  var email = document.getElementById('emailNew').value
  var pass = document.getElementById('passNew').value;

  if(username == "" || email == "" || pass == ""){
    alert("You have to fill each an every field in the ford in order to sign up.");
  }

}

function login(){
  var loginUser = document.getElementById('loginUser').value;
  var loginPass = document.getElementById('loginPass').value;

  if(loginUser == "admin" && loginPass == "admin"){
    window.location("dashboard.html");
  }
}
