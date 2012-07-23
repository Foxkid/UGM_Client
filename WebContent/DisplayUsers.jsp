	<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This page displays all the users that are returned from the FID system.
		DEPENDCIES - Header.jsp, Footer.jsp, Hover.js
					
	 -->
	 
	<%@ include file="jsp/header.jsp"%>
	
	<div id="contentContainer">
		<div id="contentHeader">
			<div>&nbsp;</div>
			<a id="DisplayUsers_Add" class="normalButton absoluteTopRight" href="addUser.jsp">++ Add New</a> 
			<form action="SearchUser" method="POST">
				<input type="text" name="SearchText" id="SearchText" /> 
				<input type="submit" name="searchuser" value="Search" id="SearchButtonListUG"/>
			</form>
			<a id="DisplayUsers_Back" class="normalButton absoluteTopLeft" href="dashboard.jsp"> << Back </a>
		</div>
		
		<% ArrayList<FHuserClass> FHUserList = (ArrayList<FHuserClass>)request.getAttribute("userList"); %>
		
		<div class="innerContent">
			<ul class="list" id="DisplayUsers_UserList">
				<%
					for (ListIterator<FHuserClass> i = FHUserList.listIterator(); i.hasNext();) {
						FHuserClass fhuser = new FHuserClass();
						fhuser = (FHuserClass)i.next();
				%>
						<li class="UserList_li">
							<div class="SelectedUserID" style="display: none;" id="userid"> <%=fhuser.getId()%> </div>
							<div class="hotspot">
								<div class="preview">
									<div class="color" style="background-color: #00316D"></div>
								</div>
								<span class="title">
									<%=fhuser.getLast_name()%> <%=fhuser.getFirst_name()%> 
								</span>
								<p class="description"><%=fhuser.getEmail()%></p>	
															
								<a class="normalButton absoluteTopRight makeCopyButton" id="makeCopy" href="javascript:postwith('CopyUser',{userid:'<%=fhuser.getId()%>', request_type:'Copy_User'})" style="display: none">+ Make Copy</a> 
								<a class="normalButton absoluteTopRight deleteButton" id="delete_hover" style="display: none">X</a>
							</div>	
						</li>
				<% 
					} 
				%>

			</ul>
		</div>
	</div>		
	
	<script src="js/utility.js" type="text/javascript"></script>
	
	<%@ include file="jsp/footer.jsp"%>
