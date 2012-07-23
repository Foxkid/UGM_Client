package client.application.servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.connection.ServerConnectionHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

public class CopyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Specify the Resource to be used on the server side.
		String ResourceName = "UserDetails";
				
		String user_id = request.getParameter("userid");		
		String request_type = request.getParameter("request_type");
		
		//Create get User Details.
		FHuserClass user = new FHuserClass();
		user.setId(user_id);
		
		JSONClass jclass = new JSONClass();
		jclass.setFHUser(user);		
		
		JSONMessage json_message = new JSONMessage();
		json_message.setMessageType("getUserDetailsMessage");
		json_message.setMessagePayload(jclass);
		
		//Forward deleteUserMessage/Json
		String jsonUserDetailsString = new Gson().toJson(json_message);
		
		//Get the Response JSON from FID server.
		String userDetailsResponse = new ServerConnectionHandler().getServerResponse(ResourceName, jsonUserDetailsString);
			
		
		
		Type type = new TypeToken<JSONMessage>() {}.getType();
		JSONMessage result = new Gson().fromJson(userDetailsResponse, type);
		JSONClass jsonPayload = result.getMessagePayload();
		
		ArrayList<FHuserClass> FHUserList = new ArrayList<FHuserClass>();
		FHUserList = (ArrayList<FHuserClass>) jsonPayload.getFHUserClassList();
		
		
		
		if(jsonPayload.isSuccess()) {
			if(request_type.equals("Copy_User")) {
				request.setAttribute("userList", FHUserList);
				request.getRequestDispatcher("/CopyUsers.jsp").forward(request, response);
			} else if(request_type.equals("Modify_User")) {
				request.setAttribute("userList", FHUserList);
				request.getRequestDispatcher("/ModifyUser.jsp").forward(request, response);
			}
		} else {
			
		}		
				
	}

}
