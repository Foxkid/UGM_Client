	<%@ include file="jsp/header.jsp"%>
	
	<div id="contentContainer">
		<div id="contentHeader">
		<div>&nbsp;</div>
			<a id="DisplayUsers_Add" class="normalButton absoluteTopRight" href="addUser.jsp">++ Add New</a> 
			<input type="text" name="SearchText" id="SearchText" /> <input type = "button" name = "SearchButton" value="Search" onclick="searchuser();" id="SearchButtonListUG"/>
			<a id="DisplayUsers_Back" class="normalButton absoluteTopLeft" href="dashboard.jsp"> << Back </a>
		</div>
		<% 
		ArrayList<FHGroupClass> FHGroupList = (ArrayList<FHGroupClass>)request.getAttribute("groupList");
		%>
		
		<div class="innerContent">
            <ul class="list" id="GroupList">
	            <%
				for (ListIterator<FHGroupClass> i = FHGroupList.listIterator(); i.hasNext();) {
					FHGroupClass fhgroup = new FHGroupClass();
					fhgroup = (FHGroupClass)i.next();
				%>
				<li onclick="submitgroup('<%= fhgroup.getGroup_name()%>');">
                <div class="preview">
                	<div class="color" style="background-color:#00316D"></div>
               	</div>
                <span class="title" > <%=fhgroup.getGroup_name()%> </span>
                <p class="description" > <%= fhgroup.getDescription()%></p>
         	    <div class="hotspot"></div>
                   <a class="normalButton absoluteTopRight makeCopyButton"  href="profile/" id="makeCopy">+ Make Copy</a>
                   <a class="normalButton absoluteTopRight deleteButton" href="profile/" id="delete_hover">X</a>
                </li>
                <% } %>
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