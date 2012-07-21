<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This is the header page which displays the user session ID and the Framehawk logo.
		       This is referenced in all the JSP pages on the client.		
					
-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  import="java.sql.*,fh.resources.json.*,java.util.ArrayList,java.util.ListIterator"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>UGM</title>

	<link rel="stylesheet" href="css/index.css" type="text/css">

	<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="js/validation.js" type="text/javascript"></script>
	 
	<link href='http://fonts.googleapis.com/css?family=Average' rel='stylesheet' type='text/css'>
</head>
<body>
	<div id="banner">
      	<div id="bannerContent">
         	<div id="topLogo"></div>      
         	<div id="logoutForm">
            	<span> You are logged in as </span>
            	<span class="loggedInUserName" >
            		<font color="#000000">
            			<%= request.getSession().getAttribute("usernameSession")%>
            		</font>
            	</span>
            	<a href="/logout"> Log Out </a>
         	</div>         
         	<div id="launchpadStudioLogo"></div>
      	</div>
   	</div>