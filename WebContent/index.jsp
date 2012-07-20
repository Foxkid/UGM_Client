	
	<%@ include file="jsp/header.jsp"%>   
	
    <div id="contentContainer">         
         <div class="innerContentLogin">
         	<div id="loginInnerContent"> 
				<div id="form_div">
					<form action="Login" method="post">					    
						<b>Username : </b><input type="text" id="username" name="username"/> <span id="error_username"> Please enter a valid email id.</span> <br/><br/>
						<b>Password &nbsp;:</b> <input type="password" id="Login_Password" name="password"/>
						<br/><br/>			
						<input type="submit" value="Login" class="Login_submit" id="Login_submit"/>		
					</form>
				</div>
	    	</div>
        </div>            
    </div>
    <script type="text/javascript">
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
	</script>
	<%@ include file="jsp/footer.jsp"%>   
   
