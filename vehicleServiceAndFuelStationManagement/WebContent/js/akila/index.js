const sighUpButton = document.getElementById("signUp");
const sighInButton = document.getElementById("signIn");
const container = document.getElementById("back-container");

sighUpButton.addEventListener('click',() => container.classList.add('right-panel-active'));
sighInButton.addEventListener('click',() => container.classList.remove('right-panel-active'));


var slideIndex = 0;
slideShow();

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
