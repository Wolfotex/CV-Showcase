//function for the query form
function myFunction(){
    var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
       
    let name= document.quedetail.fname.value;
    if(name==""){
         alert("Please enter your First Name");
         return false;
    }
    let surname= document.quedetail.lname.value;
    if(surname==""){
         alert("Please enter your Surname");
         return false;
    }
    let email= document.quedetail.email.value;
    if(!email.match(mailformat)){
         alert("Please enter your Email address");
         return false;
    }

    let rate = "";
    if(document.getElementById('star5').checked) {
        rate = "5";
    }else if(document.getElementById('star4').checked) {
        rate = "4";
    }else if(document.getElementById('star3').checked) {
        rate = "3";
    }else if(document.getElementById('star2').checked) {
        rate = "2";
    }else if(document.getElementById('star1').checked) {
        rate = "1";
    }

    let det= document.quedetail.details.value;
    if(det==""){
         alert("Please enter the details");
         return false;
    }
    
   //Displaying the summary and disappearing the query form
    document.getElementById("mysummary").style.display="block"
    document.getElementById("que").style.display="none"
    
   //inserting the user inputs
    if(name!==""){
      document.getElementById("FNAME").innerHTML = name;
    }
    
    if(surname!==""){
      document.getElementById("LNAME").innerHTML = surname;
    }
    
    if(email!==""){
      document.getElementById("EMAIL").innerHTML = email;
    }
    
    if(rate!==""){
      document.getElementById("RATE").innerHTML = rate + " Stars";
    }
    
    if(det!==""){
      document.getElementById("DETAILS").innerHTML = det;
    }
   }

   let msg = "Dear " + name + " thank you very much for your feedback. You have rated our site " + rate + "stars, and your comment was Very informative website."
   
   //function for edit button
   function editFormFunction(){
       document.getElementById("mysummary").style.display="none";
       document.getElementById("que").style.display="block"
   }
   
   //function for the submit button
   function submitFormFunction(){
        let name= document.quedetail.fname.value;
        let rate = "";
        if(document.getElementById('star5').checked) {
            rate = "5";
        }else if(document.getElementById('star4').checked) {
            rate = "4";
        }else if(document.getElementById('star3').checked) {
            rate = "3";
        }else if(document.getElementById('star2').checked) {
            rate = "2";
        }else if(document.getElementById('star1').checked) {
            rate = "1";
        }

        let msg = "Dear " + name + " thank you very much for your feedback. You have rated our site " + rate + " stars, and your comment was Very informative website."

       document.getElementById("finalPopupMsg").innerText = msg;
       document.getElementById("finalPopup").style.display = "block"
   }
       
   