package client.application.servlets;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

/*
 * Servlet implementation class for Servlet: InsertUser
 * @author rohit
 */
public class InsertUser extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public InsertUser() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String first_name = request.getParameter("firstname");
		String last_name = request.getParameter("lastname");
		String user_password = request.getParameter("password");
		String user_email = request.getParameter("email");
		String user_group = request.getParameter("group");

		JSONMessage json_message = new JSONMessage();
		json_message.setMessageType("addUserMessage");
		FHuserClass user = new FHuserClass();
		JSONClass jclass = new JSONClass();

		//Add the user details to the 
	//	user.setUser_name(user_name);
		user.setFirst_name(first_name);
		user.setLast_name(last_name);
		user.setPassword(user_password);
		user.setEmail(user_email);
		user.setGroup(user_group);

		jclass.setFHUser(user);

		//Set the message payload.
		json_message.setMessagePayload(jclass);

		//Get the final json string.
		String jsonStringUser = new Gson().toJson(json_message);
		request.setAttribute("jsonStringUser", jsonStringUser);
		request.getRequestDispatcher("InsertUserFromJson").forward(request,
				response);
	}
}