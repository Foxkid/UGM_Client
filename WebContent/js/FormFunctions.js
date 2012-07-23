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
						for(var index=1;index<data.messagePayload.FHGroupClassList.length;index++){
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