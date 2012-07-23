/*
 * This java class handles the connection parameters to the FID server.
 * 
 * (!Important) Please be careful while changing the parameters.  
 * 				There parameters are used throughout the client application.
 *              This is a read-only class.
 * 
 * @Authors 		- FLIP TEAM ( FRMAEHAWK.COM)
 * Email 			- FLIP@FRAMEHAWK.COM
 * Date Modified	- 19th July 2012
 */

package server.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class ServerConnectionHandler {
	private String fid_url = "http://localhost:8080";
	private String application_name = "FID";
	private String slash = "/";
	
	private String createUrl() {
		return getFid_url().concat(slash).concat(getApplication_name());
	}
	
	private String getFid_url() {
		return fid_url;
	}
	
	private String getApplication_name() {
		return application_name;
	}
	
	private String getServerUrl() {
		return createUrl();
	}
	
	public String getResourceURL(String Resource) {
		return getServerUrl().concat(slash).concat(Resource);
	}
			
	public String getServerResponse(String ResourceName, String RequestJSON) throws ClientProtocolException, IOException {
		
		//Create a resource URL
		String ResourceUrl = getResourceURL(ResourceName);
		
		//Create a HttpClient.
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(ResourceUrl);

		//Add the POST parameters.
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
		postParameters.add(new BasicNameValuePair("json_request_message", RequestJSON));		
    	httpPost.setEntity(new UrlEncodedFormEntity(postParameters));
		HttpResponse fidresponse = client.execute(httpPost);		
		
		//Get the response entity.
		HttpEntity entity  = fidresponse.getEntity();
		BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent()));
		
		//Read the response from the FID.
		String lineRead = null;
		String FID_response = "";
		while ((lineRead=br.readLine())!=null) {
			FID_response=FID_response+lineRead;
		}
		
		//This assumens that the response is one line of JSON Code.
		return(String)FID_response;
	}
}
