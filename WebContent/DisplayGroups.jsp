	<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This page displays all the groups that are returned from the FID system.
		DEPENDCIES - Header.jsp, Footer.jsp, Hover.js
					
	 -->	
	
	<%@ include file="jsp/header.jsp"%>
	
	<div id="contentContainer">
		<div id="contentHeader">
		<div>&nbsp;</div>
			<a id="DisplayUsers_Add" class="normalButton absoluteTopRight" href="addUser.jsp">++ Add New</a> 
			<input type="text" name="SearchText" id="SearchText" /> <input type = "button" name = "SearchButton" value="Search" onclick="searchuser();" id="SearchButtonListUG"/>
			<a id="DisplayUsers_Back" class="normalButton absoluteTopLeft" href="dashboard.jsp"> << Back </a>
		</div>
		
		<% ArrayList<FHGroupClass> FHGroupList = (ArrayList<FHGroupClass>)request.getAttribute("groupList"); %>
		
		<div class="innerContent">
            <ul class="list" id="GroupList">
	            <%
					for (ListIterator<FHGroupClass> i = FHGroupList.listIterator(); i.hasNext();) {
						FHGroupClass fhgroup = new FHGroupClass();
						fhgroup = (FHGroupClass)i.next();
				%>
						<li>
							<div class="SelectedUserID" style="display: none;" id="groupid"> <%=fhgroup.getId()%> </div>
							<div class="hotspot">
	                			<div class="preview">
	                				<div class="color" style="background-color:#00316D"></div>
	               				</div>
	               		 		<span class="title" > <%=fhgroup.getGroup_name()%> </span>
	                			<p class="description" > <%= fhgroup.getDescription()%></p>         	    
	                			<a class="normalButton absoluteTopRight makeCopyButton" id="makeCopy" style="display: none">+ Make Copy</a>
	                			<a class="normalButton absoluteTopRight deleteButton" id="delete_hover" style="display: none">X</a>
                			</div>
                		</li>
                <% } %>
            </ul>        
         </div>
     </div>   
    
    <script src="js/utility.js" type="text/javascript"></script>
    	
	<%@ include file="jsp/footer.jsp"%>