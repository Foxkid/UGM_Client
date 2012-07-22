package client.application.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
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
import com.google.gson.reflect.TypeToken;

import fh.resources.json.FHGroupClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

public class DeleteGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteGroup() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Specify the Resource to be used on the server side.
		String ResourceName = "DeleteGroup";
		
		PrintWriter out = response.getWriter();		
		String group_id = request.getParameter("groupid");
		
		//Create deleteGroupMessage/Json
		FHGroupClass group = new FHGroupClass();
		group.setId(group_id);
		
		JSONClass jclass = new JSONClass();
		jclass.setFHGroup(group);
		
		JSONMessage json_message = new JSONMessage();
		json_message.setMessageType("deleteGroupMessage");
		json_message.setMessagePayload(jclass);
		
		//Forward deleteUserMessage/Json
		String jsonDeleteGroupString = new Gson().toJson(json_message);
		
		///Create a HTTP client
		DefaultHttpClient client = new DefaultHttpClient();
		
		//Create a server connection handler.
		String ResourceUrl = new ServerConnectionHandler().getResourceURL(ResourceName);
					
		//The URL refers to the servlet as per the web.xml on the FID.
		HttpPost httpPost = new HttpPost(ResourceUrl);
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		
		//Send post it as a "json_message" parameter.
    	postParameters.add(new BasicNameValuePair("json_request_message", jsonDeleteGroupString));
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
		
		//Read the JSON Message.
		String deleteUserResponse = (String)FID_response;
		Type type = new TypeToken<JSONMessage>() {}.getType();
		JSONMessage result = new Gson().fromJson(deleteUserResponse, type);
		JSONClass jsonPayload = result.getMessagePayload();
		
		
		//Send the appropriate error message back to the JSP.		
		if(jsonPayload.isSuccess()){
			out.print("SUCCESS");
		} else {
			out.print("ERROR");
		}		
		
	}

}
