//IT19120058
//Geethika L.W.S

$("#b1").click(function() {
	$('html, body').animate({
		scrollTop : $("#section1").offset().top
	}, 500);
});

$("#b2").click(function() {
	$('html, body').animate({
		scrollTop : $("#section2").offset().top
	}, 500);
});

$("#b3").click(function() {
	$('html, body').animate({
		scrollTop : $("#section3").offset().top
	}, 700);
});

$("#b4").click(function() {
	$('html, body').animate({
		scrollTop : $("#section4").offset().top
	}, 700);
});

var coll = document.getElementsByClassName("collapsible");
var i;

for (i = 0; i < coll.length; i++) {
	coll[i].addEventListener("click", function() {
		this.classList.toggle("active");
		var content = this.nextElementSibling;
		if (content.style.maxHeight) {
			content.style.maxHeight = null;
		} else {
			content.style.maxHeight = content.scrollHeight + "px";
		}
	});
}

