	<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This page has the code to display the user form used in 'Add User' and the 'Modify User' pages.		
					
	-->
	<div id="contentContainer">      
         <div id="contentHeader" >
            	<h1>Add Users</h1>            
	    		<a id="add" class="normalButton absoluteTopLeft" href="DisplayUsers?action=display">&#60;&#60; Back</a>
         </div>
         
             
         <div class="innerContent">
            <div class="innerContentBackground">
				<div id="userForm">
				<form id="InsertUserForm" method="post">
					<table border="0" width="300">
						<tr>
							<td>
								<label> Email: </label>
							</td>
							<td>
								<input type="text" id="email" name="email" value=<%=fhuser.getEmail()%>>
							</td>							
						</tr>
						<tr>
							<td>
								<label> First Name: </label>
							</td>
							<td>
								<input type="text" id="fname" name="firstname" value=<%=fhuser.getFirst_name()%>>
							</td>
						</tr>
						<tr>
							<td>
								<label> Last Name: </label>
							</td>
							<td>
								<input type="text" id="lname" name="lastname" value=<%=fhuser.getLast_name()%>>
							</td>
						</tr>						
						<tr>
							<td>
								<label> Password: </label>
							</td>
							<td>
								<input type="password" id="password" value=<%=fhuser.getPassword()%>>
							</td>
						</tr>
						<tr>
							<td>
								<label> Retype Password: </label>
							</td>
							<td>
								<input type="password" id="retype_password" value=<%=fhuser.getPassword()%>>
							</td>
						</tr>
						<tr>
							<td>
								<label> Privilege: </label>
							</td>
							<td>
								<span id="userPrivilege" style="display: none"> <%=fhuser.getRole_id()%> </span>
								<select id="Privilege" name="privilege" style="width: 12em;">									
			 					</select>
			 				</td>
						</tr>
						<tr>
							<td>
								<label> Group: </label>
							</td>
							<td>
								<span id="userGroup" style="display: none"> <%=fhuser.getGroup()%> </span>
								<select id="Groups" name="group" style="width: 12em;">									
	 							</select>
	 						</td>
						</tr>
					</table>
					<input type="button" value="+ Submit" class="normalButton absoluteTopRight submitButton" id="add_user_submit"/>
				</form>
			</div>
	   	</div>
     </div>            
   </div>


