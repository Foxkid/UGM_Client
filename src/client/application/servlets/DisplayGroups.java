package client.application.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
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
import com.google.gson.reflect.TypeToken;

import fh.resources.json.FHGroupClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

 public class DisplayGroups extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	public DisplayGroups() {
		super();
	}   	
 	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Specify the Resource to be used on the server side.
		String ResourceName = "DisplayGroups";
		
		String action = request.getParameter("action");
		String gname = request.getParameter("getgroupbyname");
		JSONMessage json_message = new JSONMessage();
		
	    request.setAttribute("action", action);
		   if(action.equals("getGroup")){
			   request.setAttribute("getgroupbyname",gname);
		   } else {
				request.setAttribute("getgroupbyname","");
		   }
		 		
		json_message.setMessageType("groupListRequest");
		JSONClass jclass= new JSONClass();

		jclass.setSessionID();
		
		// Set the message payload.
		json_message.setMessagePayload(jclass);	
		
		//Get the final json string.
		String jsonStringGroupList = new Gson().toJson(json_message);
		
		///Create a HTTP client
		DefaultHttpClient client = new DefaultHttpClient();
		
		//Create a server connection handler.
		String ResourceUrl = new ServerConnectionHandler().getResourceURL(ResourceName);
		
		//The URL refers to the servlet as per the web.xml on the FID.
		HttpPost httpPost = new HttpPost(ResourceUrl);
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		
		//Send post it as a "json_message" parameter.
    	postParameters.add(new BasicNameValuePair("json_message", jsonStringGroupList));
    	postParameters.add(new BasicNameValuePair("action", action));
    	postParameters.add(new BasicNameValuePair("getgroupbyname", gname));
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
				
		String displayGroupResponse = (String)FID_response;
		Type type = new TypeToken<JSONMessage>() {}.getType();
		JSONMessage result = new Gson().fromJson(displayGroupResponse, type);
		JSONClass jsonPayload = result.getMessagePayload();
		
		ArrayList<FHGroupClass> FHGroupList = new ArrayList<FHGroupClass>();
		FHGroupList = (ArrayList<FHGroupClass>)jsonPayload.getFHGroupClassList();
		
		if(action.equals("display"))
		{		
			request.setAttribute("groupList", FHGroupList);
			getServletContext().getRequestDispatcher("/DisplayGroups.jsp").forward(request, response);
		}
		else if(action.equals("getGroup"))
		{	
			for(int i=0;i<FHGroupList.size();i++)
			{	
				if(FHGroupList.get(i).getGroup_name().equals(gname))
				{
					request.setAttribute("gid", FHGroupList.get(i).getId());
					request.setAttribute("groupname", gname);
					request.setAttribute("description", FHGroupList.get(i).getDescription());
					
			  }
			}
			getServletContext().getRequestDispatcher("/modifyGroup.jsp").forward(request, response);
		}
		else{}
	}   
}