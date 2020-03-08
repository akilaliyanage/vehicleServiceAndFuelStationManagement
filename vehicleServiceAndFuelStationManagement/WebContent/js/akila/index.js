const sighUpButton = document.getElementById("signUp");
const sighInButton = document.getElementById("signIn");
const container = document.getElementById("back-container");

sighUpButton.addEventListener('click',() => container.classList.add('right-panel-active'));
sighInButton.addEventListener('click',() => container.classList.remove('right-panel-active'));

