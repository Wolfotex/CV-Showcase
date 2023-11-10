//function for the query form
function myFunction(){
    var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
       
    let name= document.quedetail.fname.value;
    if(name==""){
         alert("Please enter your First Name");
         return false;
    }

    let gender= document.quedetail.gender.value;
    if(gender==""){
         alert("Please choose a gender");
         return false;
    }

    let age= document.getElementById("age").value;
    var pattern = /^[0-9]+$/;
    if(age == ""){
        alert("Please enter your age");
    }
    else if(!age.match(pattern)){
        alert("Please only enter numeric characters only for your Age!")
    }
    
    let occu= document.quedetail.fname.value;
    if(occu==""){
         alert("Please enter your occupation");
         return false;
    }

    let email= document.quedetail.email.value;
    if(!email.match(mailformat)){
         alert("Please enter your Email address");
         return false;
    }

    let Contact= document.getElementById("Contact").value;
    var pattern = /^[0-9]+$/;
    if(Contact == ""){
        alert("Please enter your contact number");
    }
    else if(!Contact.match(pattern)){
        alert("Please only enter numeric characters only for your Contact number!")
    }
   
    let pass= document.getElementById("pass").value;
    var passw = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;
    if(pass==""){
         alert("Please enter your password");
         return false;
    }else if(!pass.value.match(passw)){
        alert("password should be between 6 to 20 characters which contain at least one numeric digit, one uppercase and one lowercase letter, please check your password again")
    }

    let province= document.getElementById("province").value;
    if(province==""){
         alert("Please choose a prefered province");
         return false;
    }

    let theme= document.quedetail.theme.value;
    if(theme==""){
         alert("Please choose a prefered theme");
         return false;
    }
    
    let attFilter= document.quedetail.attFilter.value;
    if(attFilter==""){
         alert("Please choose a attorney filter");
         return false;
    }


    alert("Dear thank you for using Valor - Advocates")
}

    
       
   