package client.application.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import fh.resources.json.FHGroupClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

/**
 * Servlet implementation class for Servlet: InsertGroup
 *  @author rohit
 */
public class InsertGroup extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public InsertGroup() {
		super();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	
	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		String group_name = request.getParameter("username");
		String description = request.getParameter("description");
		
		JSONMessage json_message = new JSONMessage();
		json_message.setMessageType("addGroupMessage");
		FHGroupClass group = new FHGroupClass();
		JSONClass jclass= new JSONClass();
		
		//Add the user details to the 
		group.setGroup_name(group_name);
		group.setDescription(description);	
		
		jclass.setFHGroup(group);
		
		//Set the message payload.
		json_message.setMessagePayload(jclass);
		
		//Get the final json string.
		String jsonStringGroup = new Gson().toJson(json_message);
		request.setAttribute("jsonStringGroup", jsonStringGroup);
		request.getRequestDispatcher("InsertGroupFromJson").forward(request,
				response);
	}
}