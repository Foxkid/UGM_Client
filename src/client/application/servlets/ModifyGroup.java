package client.application.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fh.resources.json.FHGroupClass;
import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

/*
 * Servlet implementation class for Servlet: InsertUser
 * @author rohit
 */
public class ModifyGroup extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public ModifyGroup() {
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
		
		response.setContentType("text/html");
      
		String group_id=request.getParameter("gid");
		String group_name = request.getParameter("groupname");
	//	StringBuffer description = new StringBuffer(request.getParameter("description"));
		String description = new String(request.getParameter("description"));
	
		JSONMessage json_message = new JSONMessage();
		json_message.setMessageType("fidUpdateGroup");
		FHGroupClass group = new FHGroupClass();
		JSONClass jclass = new JSONClass();

		//Add the user details to the 
		group.setGroup_name(group_name);
		group.setDescription(description);
		
		jclass.setFHGroup(group);

		//Set the message payload.
		json_message.setMessagePayload(jclass);

		//Get the final json string.
		String ModifyjsonStringGroup = new Gson().toJson(json_message);
		request.setAttribute("ModifyjsonStringGroup", ModifyjsonStringGroup);
		request.setAttribute("gid", group_id);
		request.getRequestDispatcher("ModifyGroupFromJson").forward(request,
				response);
	}
}




