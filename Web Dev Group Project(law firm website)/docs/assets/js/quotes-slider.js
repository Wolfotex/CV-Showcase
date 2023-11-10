var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
  showSlides(slideIndex += n);
}

function currentSlide(n) {
  showSlides(slideIndex = n);
}

function showSlides(n) {
  var i;
  var quotes = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("dot");
  if (n > quotes.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = quotes.length}
  for (i = 0; i < quotes.length; i++) {
    quotes[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
      dots[i].className = dots[i].className.replace(" active", "");
  }
  quotes[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
}