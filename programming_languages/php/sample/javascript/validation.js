function validateForm(){
    var valid = true;
    x = document.forms["myForm"]["fname"].value;
     if( x == null || x == "" ){
        document.getElementById("demo").innerHTML = "Please Enter Name";
        // alert("Enter name");
        valid = false;
    }
    else{
        document.getElementById("demo").innerHTML = "";

    }
    x = document.forms["myForm"]["lname"].value;
     if( x == null || x == "" ){
        document.getElementById("demo1").innerHTML = "Please Enter Last Name";
        // alert("Enter name");
        valid = false;
    }
     else{
        document.getElementById("demo1").innerHTML = "";

    }
    x = document.forms["myForm"]["email"].value;
        var atpos=x.indexOf("@");
        var dotpos=x.lastIndexOf(".");
        if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
            {
            document.getElementById("demo2").innerHTML = "Please Enter Valid Email";
            valid = false ;
        }

    


    return valid;
   }