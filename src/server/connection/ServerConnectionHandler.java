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
	
}
