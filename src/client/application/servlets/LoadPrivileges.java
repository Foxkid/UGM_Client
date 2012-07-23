package client.application.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import server.connection.ServerConnectionHandler;

import com.google.gson.Gson;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;


public class LoadPrivileges extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Specify the Resource to be used on the server side.
		String ResourceName = "LoadPrivileges";
		
		JSONMessage json_message = new JSONMessage();		
		JSONClass jclass= new JSONClass();
		
		//Add the user details to the				
		json_message.setMessageType("privilegeListDropdownRequest");
		jclass.setSessionID(request.getParameter("SessionId"));
		
		//Set the message payload.
		json_message.setMessagePayload(jclass);
		
		//Get the final JSON string.
		String jsonLoadPrivilege = new Gson().toJson(json_message);
		
		///Create a HTTP client
		DefaultHttpClient client = new DefaultHttpClient();
		
		//Create a server connection handler.
		String ResourceUrl = new ServerConnectionHandler().getResourceURL(ResourceName);
		
		//The URL refers to the servlet as per the web.xml on the FID.
		HttpPost httpPost = new HttpPost(ResourceUrl);
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		
				
		//Send post it as a "json_message" parameter.
    	postParameters.add(new BasicNameValuePair("json_request_message", jsonLoadPrivilege));
    	httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
		HttpResponse fidresponse = client.execute(httpPost);		
		
		HttpEntity entity  = fidresponse.getEntity();
		BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
		
		//Read the response from the FID.
		String lineRead = null;
		String FID_response = "";
		while ((lineRead=br.readLine())!=null) {
			FID_response=FID_response+lineRead;
		}
				
		String loadPrivilegesResponse = (String)FID_response;
		
		// Write response data as JSON back to the JQuery.
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(loadPrivilegesResponse);	    	
		
	}

}
