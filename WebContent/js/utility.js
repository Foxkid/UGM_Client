/*
 * This script displays the 'make copy' and 'delete (X)' buttons on the list user and group pages.
 * There are two animations that can be used - fadeout and slideup. 
 * Once of the animation is commented.
 * @author - flipteam@framehawk.com
 * References - this script is referenced in DisplayUsers.jsp and DisplayGroup.jsp 
 * Requires - JQuery. (Tested with 1.7)
 */

$('ul.list li').hover(function(){
	$('#makeCopy', this).show();  
	$('#delete_hover', this).show();
},function(){
	$('#delete_hover', this).hide();
	$('#makeCopy', this).hide();
});

$(".deleteButton").click(function() {
	var parent = $(this).parent().parent();
	//parent.fadeOut('slow', function() {$(this).remove();});	
	var type = $(this).parent().parent().children(".SelectedUserID").attr("id");
	if(type=="userid"){
		var userid = $(this).parent().parent().children(".SelectedUserID").html();
		$.ajax({
			type: "POST",
			url: "DeleteUser",
			data: "userid="+ userid,
			cache: false,
			success: function(msg)
			{
				if(msg != 'ERROR'){				
					parent.slideUp('slow', function() {$(this).remove();});
				}
				else{
					alert("Sorry! There was some problem.");
				}			
			}		
		});
	} else if(type=="groupid"){
		var groupid = $(this).parent().parent().children(".SelectedUserID").html();
		$.ajax({
			type: "POST",
			url: "DeleteGroup",
			data: "groupid="+ groupid,
			cache: false,
			success: function(msg)
			{
				if(msg != 'ERROR'){				
					parent.slideUp('slow', function() {$(this).remove();});
				}
				else{
					alert("Sorry! There was some problem.");
				}			
			}		
		});
	}
	return false;
});


function postwith(url,parameters) {
	  var myForm = document.createElement("form");
	  myForm.method="post" ;
	  myForm.action = url ;
	  for (var key in parameters) {
	    var myInput = document.createElement("input") ;
	    myInput.setAttribute("name", key) ;
	    myInput.setAttribute("value", parameters[key]);
	    myForm.appendChild(myInput) ;
	  }
	  document.body.appendChild(myForm) ;
	  myForm.submit() ;
	  document.body.removeChild(myForm) ;
}

$(".hotspot").click(function() {
	var userid = $(this).parent().children(".SelectedUserID").html();	
	postwith('CopyUser',{userid:userid, request_type:'Modify_User'});	
});

/*
 * The following script is used to validate the entered email address on the index page.
 * @author - flipteam@framehawk.com
 * Requires - JQuery. (Tested with 1.7)
 */


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