/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.resources.json;

import java.util.ArrayList;
import java.security.SecureRandom;
import java.math.BigInteger;

/**
 *
 * @author anshu
 */
public class JSONClass {
    private String type; // operation:functionName, response:functionName
    
    private FHGroupClass FHGroup;
    private ArrayList<FHGroupClass>  FHGroupClassList ;
    private FHuserClass FHUser;
    private ArrayList<FHuserClass> FHUserClassList;
    private PrivilegeClass privilege;
    private ArrayList<PrivilegeClass> PrivilegeClassList;
    private RoleClass role;
    private ArrayList<RoleClass> RoleClassList;
    private RolePrivilegeClass rolePrivilege;
    private ArrayList<RolePrivilegeClass> RolePrivilegeClassList;
    private UserInGroupClass userInGroup;
    private ArrayList<UserInGroupClass> UserInGroupClassList;
    private boolean success;
    private String message;
    private String sessionID;
    private int resultCode;
	private String searchParameter;
    
    public String getSearchParameter() {
		return searchParameter;
	}

	public void setSearchParameter(String searchParameter) {
		this.searchParameter = searchParameter;
	}

	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    

    public FHGroupClass getFHGroup() {
        return FHGroup;
    }

    public void setFHGroup(FHGroupClass FHGroup) {
        this.FHGroup = FHGroup;
    }

    public FHuserClass getFHUser() {
        return FHUser;
    }

    public void setFHUser(FHuserClass FHUser) {
        this.FHUser = FHUser;
    }

    public PrivilegeClass getPrivilege() {
        return privilege;
    }

    public void setPrivilege(PrivilegeClass privilege) {
        this.privilege = privilege;
    }

    public RoleClass getRole() {
        return role;
    }

    public void setRole(RoleClass role) {
        this.role = role;
    }

    public RolePrivilegeClass getRolePrivilege() {
        return rolePrivilege;
    }

    public void setRolePrivilege(RolePrivilegeClass rolePrivilege) {
        this.rolePrivilege = rolePrivilege;
    }

    public UserInGroupClass getUserInGroup() {
        return userInGroup;
    }

    public void setUserInGroup(UserInGroupClass userInGroup) {
        this.userInGroup = userInGroup;
    }

    public ArrayList<FHGroupClass> getFHGroupClassList() {
        return FHGroupClassList;
    }

    public void setFHGroupClassList(ArrayList<FHGroupClass> FHGroupClassList) {
        this.FHGroupClassList = FHGroupClassList;
    }

    public ArrayList<FHuserClass> getFHUserClassList() {
        return FHUserClassList;
    }

    public void setFHUserClassList(ArrayList<FHuserClass> FHUserClassList) {
        this.FHUserClassList = FHUserClassList;
    }

    public ArrayList<PrivilegeClass> getPrivilegeClassList() {
        return PrivilegeClassList;
    }

    public void setPrivilegeClassList(ArrayList<PrivilegeClass> PrivilegeClassList) {
        this.PrivilegeClassList = PrivilegeClassList;
    }

    public ArrayList<RoleClass> getRoleClassList() {
        return RoleClassList;
    }

    public void setRoleClassList(ArrayList<RoleClass> RoleClassList) {
        this.RoleClassList = RoleClassList;
    }

    public ArrayList<RolePrivilegeClass> getRolePrivilegeClassList() {
        return RolePrivilegeClassList;
    }

    public void setRolePrivilegeClassList(ArrayList<RolePrivilegeClass> RolePrivilegeClassList) {
        this.RolePrivilegeClassList = RolePrivilegeClassList;
    }

    public ArrayList<UserInGroupClass> getUserInGroupClassList() {
        return UserInGroupClassList;
    }

    public void setUserInGroupClassList(ArrayList<UserInGroupClass> UserInGroupClassList) {
        this.UserInGroupClassList = UserInGroupClassList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	/**
	 * @return the sessionID
	 */
	public String getSessionID() {
		return sessionID;
	}

	/**
	 * @param sessionID the sessionID to set
	 */
	public void setSessionID() {
		SecureRandom random = new SecureRandom();
		this.sessionID = new BigInteger(130, random).toString(32);;
	}

	/**
	 * @return the resultCode
	 */
	public int getResultCode() {
		return resultCode;
	}

	/**
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
    
    
}
