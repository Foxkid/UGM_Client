/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.resources.json;

/**
 *
 * @author anshu
 */
public class RolePrivilegeClass {
    private Integer role_id;
    private Integer privilege_id;

    public Integer getPrivilege_id() {
        return privilege_id;
    }

    public void setPrivilege_id(Integer privilege_id) {
        this.privilege_id = privilege_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
    
}
