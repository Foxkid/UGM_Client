	<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This is the index page of the UGM Client. 		
					
	-->
	
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
    
    <script src="js/utility.js" type="text/javascript"></script>
    
	<%@ include file="jsp/footer.jsp"%>   
   
