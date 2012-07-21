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
	parent.slideUp('slow', function() {$(this).remove();});
	$.ajax({
		type: "POST",
		url: "",
		data: dataString,
		cache: false,
		success: function()
		{

		}
	});
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