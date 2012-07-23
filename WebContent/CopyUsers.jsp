	<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This page has the code to display the Add user form. 		
					
	-->
		
	<%@ include file="jsp/header.jsp"%>	
	
	<% ArrayList<FHuserClass> FHUserList = (ArrayList<FHuserClass>)request.getAttribute("userList"); %>
         
         <%
         		FHuserClass fhuser = new FHuserClass();
         		ListIterator<FHuserClass> iterator = FHUserList.listIterator();
				if ( iterator.hasNext()) {					
					fhuser = (FHuserClass)iterator.next();
				}
	%>   
		
	<%@ include file="jsp/userDetailsForm.jsp"%>					
	
	<script src="js/FormFunctions.js" type="text/javascript"></script>
	
	<script type="text/javascript">
		$('#add_user_submit').click(function() {
			var email = $('#email').val();
			var fname = $('#fname').val();
			var lname = $('#lname').val();
			var password = $('#password').val();
			var privilege = $('#Privilege').val();
			var groups = $('#Groups').val();
			
			$.post("InsertUser", {firstname:fname,lastname:lname,password:password,email:email,group:groups,privilege:privilege},
				function(data) {				
					alert(data.messagePayload.message);
					$('#InsertUserForm').each (function(){
						  this.reset();
					});				
			});
		});
	</script>
	
				
	<%@ include file="jsp/footer.jsp"%>
