<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This page has the code to display the group form used in 'Add Group' and the 'Modify Group' pages.		
					
-->

<div id="contentContainer">
      
	<div id="contentHeader" >
    	<h1>Add Users</h1>            
	    <a id="add" class="normalButton absoluteTopLeft" href="back/">&#60;&#60; Back</a>
    </div>
         
    <div class="innerContent">
    	<div class="innerContentBackground">
			<div id="userForm">
				<form action="InsertUser" method="post">
					<table border="0" width="300">
						<tr>
							<td>
								<label> Group Name: </label>
							</td>
							<td>
								<input type="text" id="fname" name="fname"/>
							</td>
						</tr>
						<tr>
							<td>
								<label> Description: </label>
							</td>
							<td>
								<textarea rows="10" cols="17"></textarea>
							</td>
						</tr>
					</table>
					<input type="submit" value="+ Submit" class="normalButton absoluteTopRight submitButton" id="add_user_submit"/>
				</form>
			</div>
	    </div>
	</div>            
</div>