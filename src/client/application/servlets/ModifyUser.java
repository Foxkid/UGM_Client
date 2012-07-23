package client.application.servlets;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.connection.ServerConnectionHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;
import fh.resources.json.PrivilegeClass;

public class ModifyUser extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the user filled parameters.
		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String user_password = request.getParameter("password");
		String user_email = request.getParameter("email");
		String user_group = request.getParameter("group");
		String privilege = request.getParameter("privilege");
		
		//Specify the service to be called on the server side.
		String ResourceName = "GetRoleId";
		
		//Call the RoleID service using the privilege.		
		JSONMessage json_message = new JSONMessage();
		json_message.setMessageType("getRoleIdMessage");
		JSONClass jclass = new JSONClass();
		PrivilegeClass privilegeObject = new PrivilegeClass();
		privilegeObject.setPrivilege_name(privilege);
		jclass.setPrivilege(privilegeObject);
		json_message.setMessagePayload(jclass);
		String jsonStringRoleId = new Gson().toJson(json_message);
		
		//Get the Response JSON from FID server.
		String RoleIdResponse = new ServerConnectionHandler().getServerResponse(ResourceName, jsonStringRoleId);
				
		// Get the RoleId from the 		
		Type type = new TypeToken<JSONMessage>() {}.getType();
		JSONMessage result = new Gson().fromJson(RoleIdResponse, type);
		
		//Get the response message payload.
		JSONClass message_payload = result.getMessagePayload();
		int role_id = message_payload.getRole().getId();
				
		//Specify the service to be called.
		ResourceName = "ModifyUser";
		
		//Create a JSON message.
		json_message = new JSONMessage();
		json_message.setMessageType("updateUserMessage");
		jclass = new JSONClass();
		FHuserClass user = new FHuserClass();		
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setPassword(user_password);
		user.setEmail(user_email);
		user.setGroup(user_group);
		user.setRole_id(role_id);
		jclass.setFHUser(user);

		//Set the message payload.
		json_message.setMessagePayload(jclass);

		//JSON String to be sent.
		String jsonStringUser = new Gson().toJson(json_message);
		
		System.out.println(jsonStringUser);
				
		//Get the Response JSON from FID server.
		String InsertUserResponse = new ServerConnectionHandler().getServerResponse(ResourceName, jsonStringUser);
		
		// Write response data as JSON back to the JQuery.
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(InsertUserResponse);	
	}
}



