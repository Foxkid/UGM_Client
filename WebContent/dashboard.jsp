	<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - Shows the dashboard once the user login is successful. 		
					
	-->
	<%@ include file="jsp/header.jsp"%>   
	
    <div id="contentContainer">      
         <div id="contentHeader" >
            <h1>My Dashboard</h1>            
         </div>         
         <div class="innerContent">
            <div class="innerContentDashboard">
				<div id="dashboard_container">
					<a href="DisplayUsers?action=display" id="dashboard_user"> <img src="images/user.png" alt="user"/></a>
					<a href="DisplayGroups?action=display" id="dashboard_group"><img src="images/group.png" alt="group"/></a>
					<br/>
				</div>
	    	</div>
    	</div>            
   	</div>
    
	<%@ include file="jsp/footer.jsp"%>