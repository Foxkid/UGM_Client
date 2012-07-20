package client.application.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

/**
 * Servlet implementation class for Servlet: SearchUser
 * @author rohit
 */
 public class SearchUser extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SearchUser() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("action",request.getParameter("action") );
		if(request.getAttribute("action").toString().equals("SearchUser"))
			request.setAttribute("searchuserbyname",request.getAttribute("searchuserbyname") );
			else
				request.setAttribute("searchuserbyname","");
		JSONMessage json_message = new JSONMessage();
		json_message.setMessageType("fidSearchUser");
		JSONClass jclass= new JSONClass();
		
		String userName = (String)request.getParameter("searchuserbyname");
		FHuserClass fhuser = new FHuserClass();
		fhuser.setUser_name(userName);
		
		jclass.setFHUser(fhuser);
		
		// Set the message payload.
		json_message.setMessagePayload(jclass);
		
		// Get the final json string.
		String jsonStringSearchUser = new Gson().toJson(json_message);
		request.setAttribute("jsonStringSearchUser", jsonStringSearchUser);
		request.getRequestDispatcher("SearchUserFromJson").forward(request,
                response);
	}  	
	

	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}   	  	    
}