/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.resources.json;

/**
 *
 * @author anshu
 */
public class FHuserClass {
        private String id;
        private String user_name;
        private String first_name;
        private String last_name;
        private String password;
        private Integer role_id;
        private String email;
    	private String profile_image="https://s3.amazonaws.com/tme-framehawk/fh/AVATAR.png";
    	private String group;
        
    	
    	   public String getFirst_name() {
   			return first_name;
   		}

   		public void setFirst_name(String first_name) {
   			this.first_name = first_name;
   		}

   		public String getLast_name() {
   			return last_name;
   		}

   		public void setLast_name(String last_name) {
   			this.last_name = last_name;
   		}
        public String getId() {
            return id;
        }
        
        public String getPassword() {
            return password;
        }
        
        public Integer getRole_id() {
            return role_id;
        }
        
        public void setId(String id) {
            this.id = id;
        }
        
        public void setPassword(String password) {
            this.password = password;
        }
        
        public void setRole_id(Integer role_id) {
            this.role_id = role_id;
        }
        
        
        @Override
        public String toString() {
            return String.format("id:%d, first_name:%s, last_name:%s, password:%s, role_id:%d", id, first_name, last_name, password, role_id);
        }

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
		}

		/**
		 * @return the profile_image
		 */
		public String getProfile_image() {
			return profile_image;
		}

		/**
		 * @param profile_image the profile_image to set
		 */
		public void setProfile_image(String profile_image) {
			this.profile_image = profile_image;
		}

		/**
		 * @return the group
		 */
		public String getGroup() {
			return group;
		}

		/**
		 * @param group the group to set
		 */
		public void setGroup(String group) {
			this.group = group;
		}

		/**
		 * @return the user_name
		 */
		public String getUser_name() {
			return user_name;
		}

		/**
		 * @param user_name the user_name to set
		 */
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
}
