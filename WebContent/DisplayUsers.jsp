
	<%@ include file="jsp/header.jsp"%>
	
	<div id="contentContainer">
		<div id="contentHeader">
		<div>&nbsp;</div>
			<a id="DisplayUsers_Add" class="normalButton absoluteTopRight" href="addUser.jsp">++ Add New</a> 
			<input type="text" name="SearchText" id="SearchText" /> <input type = "button" name = "SearchButton" value="Search" onclick="searchuser();" id="SearchButtonListUG"/>
			<a id="DisplayUsers_Back" class="normalButton absoluteTopLeft" href="dashboard.jsp"> << Back </a>
		</div>
		<% 
		ArrayList<FHuserClass> FHUserList = (ArrayList<FHuserClass>)request.getAttribute("userList");
		%>
		<div class="innerContent">
			<ul class="list" id="DisplayUsers_UserList">
				<%
					for (ListIterator<FHuserClass> i = FHUserList.listIterator(); i.hasNext();) {
						FHuserClass fhuser = new FHuserClass();
						fhuser = (FHuserClass)i.next();
				%>
				<li onclick="submitname('<%=fhuser.getId()%>');">
					<div class="hotspot">
					<div class="preview">
						<div class="color" style="background-color: #00316D"></div>
					</div>
					<span class="title"><%=fhuser.getFirst_name()%> <%=fhuser.getLast_name()%></span>
					<p class="description"><%=fhuser.getEmail()%></p>
									
					<a class="normalButton absoluteTopRight makeCopyButton" id="makeCopy" style="display: none">+ Make Copy</a> 
					<a class="normalButton absoluteTopRight deleteButton" id="delete_hover" style="display: none">X</a>
					</div>	
				</li>
				<% 
					} 
				%>

			</ul>
		</div>
	</div>		
	<script type="text/javascript">
		$('ul.list li').hover(function(){
		     $('#makeCopy', this).show();  //find the div INSIDE this li
		     $('#delete_hover', this).show();
		},function(){
		     $('#delete_hover', this).hide();
		     $('#makeCopy', this).hide();
		});
				
		$(".deleteButton").click(function() {
			 var parent = $(this).parent().parent();
			 //parent.fadeOut('slow', function() {$(this).remove();});
			 parent.slideUp('slow', function() {$(this).remove();});
			 $.ajax({
				  type: "POST",
				  url: "",
				  data: dataString,
				  cache: false,
				  success: function()
				  {
						  
				  }
			 });
		});
		
	</script>	
	<%@ include file="jsp/footer.jsp"%>
