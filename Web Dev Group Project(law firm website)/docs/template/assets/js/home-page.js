var prevScrollpos = window.pageYOffset;
window.onscroll = function() {
  var currentScrollPos = window.pageYOffset;
  if (prevScrollpos > currentScrollPos) {
    document.getElementById("navbar").style.top = "0";
  } else {
    document.getElementById("navbar").style.top = "-50px";
  }
  prevScrollpos = currentScrollPos;
}




document.addEventListener("DOMContentLoaded", function() {
  // specify which elements are going to behave as counters.
  var elements = document.querySelectorAll(".counter")

  elements.forEach(function(item) {
    // Add new attributes to the elements with the '.counter' HTML class
    item.counterAlreadyFired = false
    item.counterSpeed = item.getAttribute("data-counter-time") / 45
    item.counterTarget = +item.innerText
    item.counterCount = 0
    item.counterStep = item.counterTarget / item.counterSpeed

    item.updateCounter = function() {
      item.counterCount = item.counterCount + item.counterStep
      item.innerText = Math.ceil(item.counterCount)

      if (item.counterCount < item.counterTarget) {
        setTimeout(item.updateCounter, item.counterSpeed)
      } else {
        item.innerText = item.counterTarget
      }
    }
  })

  // Function to determine if an element is visible in the web page
  var isElementVisible = function isElementVisible(el) {
    var scroll = window.scrollY || window.pageYOffset
    var boundsTop = el.getBoundingClientRect().top + scroll
    var viewport = {
      top: scroll,
      bottom: scroll + window.innerHeight,
    }
    var bounds = {
      top: boundsTop,
      bottom: boundsTop + el.clientHeight,
    }
    return (
      (bounds.bottom >= viewport.top && bounds.bottom <= viewport.bottom) ||
      (bounds.top <= viewport.bottom && bounds.top >= viewport.top)
    )
  }

  // Funciton that will get fired uppon scrolling
  var handleScroll = function handleScroll() {
    elements.forEach(function(item, id) {
      if (true === item.counterAlreadyFired) return
      if (!isElementVisible(item)) return
      item.updateCounter()
      item.counterAlreadyFired = true
    })
  }

  // Fire the function on scroll
  window.addEventListener("scroll", handleScroll)
})


var slide_index = 1;
        displaySlides(slide_index);
        function nextSlide(n) {
            displaySlides(slide_index += n);
        }
        function currentSlide(n) {
            displaySlides(slide_index = n);
        }
        function displaySlides(n) {
            var i;
            var slides = document.getElementsByClassName("showSlide");
            if (n > slides.length) { slide_index = 1 }
            if (n < 1) { slide_index = slides.length }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            slides[slide_index - 1].style.display = "block";
        }


        const main = document.querySelector("right");
        const section = document.querySelector("left");
        const footer = document.querySelector("footer");
        
        const footerRect = footer.getBoundingClientRect();
        const topSpace = window.innerHeight - footerRect.height;
        const dimToInterpolateFrom =
          topSpace + footerRect.height - footerRect.height * 0.2;
        
        window.addEventListener("scroll", (event) => {
          requestAnimationFrame(() => {
            const mainRect = main.getBoundingClientRect();
            if (mainRect.bottom <= dimToInterpolateFrom + 10) {
              let normalizedValue =
                (mainRect.bottom - footerRect.height) /
                (dimToInterpolateFrom - footerRect.height);
              if (normalizedValue > 1) {
                normalizedValue = 1;
              }
              normalizedValue = 1 - normalizedValue;
              const scaleAddition = 0.06 * normalizedValue;
              const parentScale = 1 - scaleAddition;
              let parentRotateX = 20 * normalizedValue;
              if (parentRotateX > 20) parentRotateX = 20;
              const childScale = 1 / parentScale;
              main.style.setProperty(
                "transform",
                `scaleX(${parentScale}) rotateX(${parentRotateX}deg)`
              );
              section.style.setProperty("transform", `scaleX(${childScale})`);
              // console.log(normalizedValue);
            } else {
              main.style.setProperty("transform", `scaleX(1) rotateX(0deg)`);
              section.style.setProperty("transform", `scaleX(1)`);
            }
          });
        });
        
        

