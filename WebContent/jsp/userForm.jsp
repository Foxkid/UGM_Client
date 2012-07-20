<div id="contentContainer">

<div id="contentHeader">
<h1>Add Users</h1>

<a id="add" class="normalButton absoluteTopLeft" href="back/">&#60;&#60;
Back</a></div>

<div class="innerContent">
<div class="innerContentBackground">
<div id="userForm">
<form action="InsertUser" method="post">
<table border="0" width="300">
	<tr>
		<td><label> First Name: </label></td>
		<td><input type="text" id="fname" name="fname" /></td>
	</tr>
	<tr>
		<td><label> Last Name: </label></td>
		<td><input type="text" id="lname" name="lname" /></td>
	</tr>
	<tr>
		<td><label> Email: </label></td>
		<td><input type="text" id="email" name="email" /></td>
	</tr>
	<tr>
		<td><label> Password: </label></td>
		<td><input type="password" id="password" /></td>
	</tr>
	<tr>
		<td><label> Retype Password: </label></td>
		<td><input type="password" id="retype_password" /></td>
	</tr>
	<tr>
		<td><label> Privilege: </label></td>
		<td><select id="Privilege" name="Privilege" style="width: 12em;">
			<option>Test</option>
		</select></td>
	</tr>
	<tr>
		<td><label> Group: </label></td>
		<td><select id="Groups" name="group" style="width: 12em;">
			<option>Test</option>
		</select></td>
	</tr>
</table>
<input type="submit" value="+ Submit"
	class="normalButton absoluteTopRight submitButton" id="add_user_submit" />
</form>
</div>
</div>
</div>

</div>