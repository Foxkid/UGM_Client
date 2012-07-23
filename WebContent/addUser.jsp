	<!-- 
		Authors - FLIPTEAM (FRAMEHAWK.COM)
		CONTACT - FLIP@FRAMEHAWK.COM
		DATE MODIFIED - 19th July 2012
		INFO - This page has the code to display the Add user form. 		
					
	-->
		
	<%@ include file="jsp/header.jsp"%>
	
	
	
	<%@ include file="jsp/userForm.jsp"%>				
	
	<script type="text/javascript">
		$(document).ready(function() {
			var SessionId = $.trim($("#UserSessionID").html());			
			$.post("LoadPrivileges", { SessionId: SessionId},
				function(data) {
					var options = [];
					for(var index=0;index<data.messagePayload.PrivilegeClassList.length;index++){
						var privilege = data.messagePayload.PrivilegeClassList[index].privilege_name;
						options.push(privilege);						
					}	
					var mySelect = $('#Privilege');
					$.each(options, function(text,val) {
					    mySelect.append(
					        $('<option></option>').val(val).html(val)
					    );
					});
			});	
			$.post("LoadGroups", { SessionId: SessionId},
					function(data) {
						var options = [];
						for(var index=0;index<data.messagePayload.FHGroupClassList.length;index++){
							var group_name = data.messagePayload.FHGroupClassList[index].group_name;
							options.push(group_name);						
						}	
						var mySelect = $('#Groups');
						$.each(options, function(text,val) {
						    mySelect.append(
						        $('<option></option>').val(val).html(val)
						    );
						});	
				});
		});
	</script>
				
	<%@ include file="jsp/footer.jsp"%>
