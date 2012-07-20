<div id="loginInnerContent">
	<form action="Login" method="post">
	<input type="text" id="Username" name="username" value="Username" style="color:#999999;"/>
	<br/><br/>
	<input type="text" id="Fakepassword" name="Fakepassword"  style="color:#999999;" value="Password" onfocus="pwdFocus()" />
	<input type="password" id="Password" name="password" style="display:none" onblur="pwdBlur()"/>
	<br/><br/>
	<center>
		<input type="submit" value="Login" class="Login_submit" id="Login_submit"/>
	</center>	
	</form>
</div>