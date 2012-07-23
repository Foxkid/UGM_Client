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

import fh.resources.json.FHuserClass;
import fh.resources.json.JSONClass;
import fh.resources.json.JSONMessage;

public class DisplayUsers extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public DisplayUsers() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Specify the Resource to be used on the server side.
		String ResourceName = "DisplayUsers";

		String action = request.getParameter("action");
		String uname = request.getParameter("getuserbyid");
		JSONMessage json_message = new JSONMessage();

		// Block execued if the action selected by the user is sort.
		if (action.equals("sort")) {
			json_message.setMessageType("SortuserListRequest");
		} else {
			json_message.setMessageType("userListRequest");
		}

		JSONClass jclass = new JSONClass();

		jclass.setSessionID();

		// Set the message payload.
		json_message.setMessagePayload(jclass);

		// Get the final json string.
		String jsonStringUserList = new Gson().toJson(json_message);

		DefaultHttpClient client = new DefaultHttpClient();

		// Create a server connection handler.
		String ResourceUrl = new ServerConnectionHandler()
				.getResourceURL(ResourceName);

		// The URL refers to the servlet as per the web.xml on the FID.
		HttpPost httpPost = new HttpPost(ResourceUrl);
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();

		// Send post it as a "json_message" paramter.
		postParameters.add(new BasicNameValuePair("json_message",
				jsonStringUserList));
		postParameters.add(new BasicNameValuePair("getuserbyid", uname));
		httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
		HttpResponse fidresponse = client.execute(httpPost);

		HttpEntity entity = fidresponse.getEntity();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				entity.getContent()));

		// Read the response from the FID.
		String lineRead = null;
		String FID_response = "";
		while ((lineRead = br.readLine()) != null) {
			FID_response = FID_response + lineRead;
		}

		String userListResponse = (String) FID_response;
		Type type = new TypeToken<JSONMessage>() {}.getType();
		JSONMessage result = new Gson().fromJson(userListResponse, type);
		JSONClass jsonPayload = result.getMessagePayload();
			
		ArrayList<FHuserClass> FHUserList = new ArrayList<FHuserClass>();
		FHUserList = (ArrayList<FHuserClass>) jsonPayload.getFHUserClassList();

		request.setAttribute("userList", FHUserList);
		getServletContext().getRequestDispatcher("/DisplayUsers.jsp").forward(request, response);

	}
}