package client.application.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class SearchGroup extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public SearchGroup() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Specify the Resource to be used on the server side.
		String ResourceName = "SearchGroup";
		
		String searchParameter = request.getParameter("SearchText");
		JSONMessage json_message = new JSONMessage();

		// Block execued if the action selected by the user is sort.		
		json_message.setMessageType("fidSearchGroup");

		JSONClass jclass = new JSONClass();
		jclass.setSearchParameter(searchParameter);
		
		// Set the message payload.
		json_message.setMessagePayload(jclass);
		
		// Get the final json string.
		String jsonStringUserList = new Gson().toJson(json_message);

		
		
		DefaultHttpClient client = new DefaultHttpClient();

		// Create a server connection handler.
		String ResourceUrl = new ServerConnectionHandler().getResourceURL(ResourceName);

		// The URL refers to the servlet as per the web.xml on the FID.
		HttpPost httpPost = new HttpPost(ResourceUrl);
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();

		// Send post it as a "json_message" paramter.
		postParameters.add(new BasicNameValuePair("json_request_message", jsonStringUserList));
		httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
		HttpResponse fidresponse = client.execute(httpPost);

		HttpEntity entity = fidresponse.getEntity();
		BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));

		// Read the response from the FID.
		String lineRead = null;
		String FID_response = "";
		while ((lineRead = br.readLine()) != null) {
			FID_response = FID_response + lineRead;
		}

		String searchGroupResponse = (String) FID_response;
		Type type = new TypeToken<JSONMessage>() {}.getType();
		JSONMessage result = new Gson().fromJson(searchGroupResponse, type);
		JSONClass jsonPayload = result.getMessagePayload();

		ArrayList<FHGroupClass> FHGroupList = new ArrayList<FHGroupClass>();
		FHGroupList = (ArrayList<FHGroupClass>) jsonPayload.getFHGroupClassList();

		request.setAttribute("groupList", FHGroupList);
		getServletContext().getRequestDispatcher("/DisplayGroups.jsp").forward(request, response);
	}

}
