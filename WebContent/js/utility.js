/*
 * Login Part
 */
function validate(email) { 
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
   if(reg.test(email) == false) { 
      return false;
   }
   return true;
}

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