package client.application.servlets;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

/**
 * Servlet implementation class for Servlet: SearchUserFinal
 * @author rohit
 */
 public class SearchUserFinal extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
    /* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public SearchUserFinal() {
		super();
	}   	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userListResponse = (String)request.getAttribute("fidUserSearchResponse");
		Type type = new TypeToken<JSONMessage>() {
		}.getType();
		JSONMessage result = new Gson().fromJson(userListResponse, type);
		JSONClass jO = result.getMessagePayload();
		
		ArrayList<FHuserClass> FHUserSearchList = new ArrayList<FHuserClass>();
		FHUserSearchList = (ArrayList<FHuserClass>)jO.getFHUserClassList();
		
		request.setAttribute("userList", FHUserSearchList);
		getServletContext().getRequestDispatcher("/searchUser.jsp").forward(request, response);
	}  	
	
	/* (non-Java-doc)
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}   	  	    
}