/*
 * The following script is used to validate the entered email address on the index page.
 * @author - flipteam@framehawk.com
 * Requires - JQuery. (Tested with 1.7)
 */

function validate(email) { 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   if(reg.test(email) == false) { 
      return false;
   }
   return true;
}

$(document).ready(function(){            
	$('#logoutForm').css('display','none');  
});

$('#username').blur(function(){
	$validationResult = validate($("#username").val());			
	if($validationResult==false) { 
		$('#error_username').css('display','inline');
		$('#error_username').css('color','red');
		$("#username").val("");
        $('#username').focus();
	}
	if($validationResult==true) { 
		$('#error_username').css('display','none');
	}
});


/*
 * Display users.
 
function submitname(obj){     
    val="getUser";
    location.href="DisplayUsers?action="+val+"&getuserbyid="+obj;
}  

function searchuser() {
    var obj=document.getElementById("SearchText").value;
	var val="SearchUser";
	location.href="SearchUser?action="+val+"&searchuserbyname="+obj;
}
*/