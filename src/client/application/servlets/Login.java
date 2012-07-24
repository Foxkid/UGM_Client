package client.application.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import server.connection.ServerConnectionHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

/**
 * Servlet implementation class for Servlet: Login
 *
 */
 public class Login extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
    static final long serialVersionUID = 1L;
   
    
	public Login() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Specify the Resource to be used on the server side.
		String ResourceName = "Login";
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		JSONMessage json_message = new JSONMessage();
		FHuserClass user = new FHuserClass();
		JSONClass jclass= new JSONClass();
		
		//Add the user details to the 
		user.setEmail(username);
		user.setPassword(password);		
		jclass.setFHUser(user);
		
		//Set the message payload.
		json_message.setMessagePayload(jclass);
		
		//Get the final json string.
		String jsonStringUserLogin = new Gson().toJson(json_message);
		System.out.println(jsonStringUserLogin);
		
		//Call the FID Service to authenticate the credentials.		
		DefaultHttpClient client = new DefaultHttpClient();
		
		//Create a server connection handler.
		String ResourceUrl = new ServerConnectionHandler().getResourceURL(ResourceName);
		
		//The URL refers to the servlet as per the web.xml on the FID.
		HttpPost httpPost = new HttpPost(ResourceUrl);
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		
		//Send post it as a "json_message" paramter.
    	postParameters.add(new BasicNameValuePair("json_message", jsonStringUserLogin)); 
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
		
		//De-serialize the JSON using the custom library (fh.resources.json)		
		Type type = new TypeToken<JSONMessage>() {}.getType();
		JSONMessage result = new Gson().fromJson(FID_response, type);
		JSONClass jsonPayload = result.getMessagePayload();
		
		if(jsonPayload.isSuccess()){
			//Login Successful. Assign User Session
			HttpSession session = request.getSession(true);	
			session.setAttribute("usernameSession",  (String)username);		
			
			//Display the user dashboard.
			request.setAttribute("loginCode", jsonPayload.getResultCode());
			request.getRequestDispatcher("/dashboard.jsp").forward(request,response);
			
		}else {
			//Login Faliure.Need to pass the msg backward.
			request.setAttribute("loginCode", jsonPayload.getResultCode());
			request.getRequestDispatcher("/").forward(request,response);
			
		}
	}	 	  	    
}