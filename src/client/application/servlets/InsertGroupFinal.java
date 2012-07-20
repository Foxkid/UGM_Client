package client.application.servlets;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

/**
 * Servlet implementation class for Servlet: InsertGroupFinal
 * @author rohit
 */
 public class InsertGroupFinal extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public InsertGroupFinal() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String addGroupResponse = (String)request.getAttribute("fidAddGroupResponse");
		Type type = new TypeToken<JSONMessage>() {
		}.getType();
		JSONMessage result = new Gson().fromJson(addGroupResponse, type);
		JSONClass jO = result.getMessagePayload();
		
		if(jO.isSuccess()) {
			getServletContext().getRequestDispatcher("/dashboard.jsp").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/addGroup.jsp").forward(request,
					response);
		}
	}   	  	    
}