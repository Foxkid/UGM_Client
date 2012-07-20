/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.resources.json;

/**
 *
 * @author anshu
 */
public class RoleClass {
         private Integer id;
        private String role_name;

        public Integer getId() {
            return id;
        }

        public String getRole_name() {
            return role_name;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setRole_name(String role_name) {
            this.role_name = role_name;
        }
        
        @Override
         public String toString() {
            return String.format("id:%d,role_name:%s", id, role_name);
        }
}
