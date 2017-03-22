package com.deepjoshi.logibox.Model;

/**
 * Created by Deep Joshi on 23-03-2017.
 */

public class DjModel {


    /**
     * status : 1
     * user_details : {"rid":3,"fname":"nanu","lname":"dabhi","address":"thaltej","phone":"9879221773","email":"nannu@gmail.com","username":"nanu123"}
     * message : Customer registration is successfully done.
     */

    private int status;
    private UserDetailsBean user_details;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public UserDetailsBean getUser_details() {
        return user_details;
    }

    public void setUser_details(UserDetailsBean user_details) {
        this.user_details = user_details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class UserDetailsBean {
        /**
         * rid : 3
         * fname : nanu
         * lname : dabhi
         * address : thaltej
         * phone : 9879221773
         * email : nannu@gmail.com
         * username : nanu123
         */

        private int rid;
        private String fname;
        private String lname;
        private String address;
        private String phone;
        private String email;
        private String username;

        public int getRid() {
            return rid;
        }

        public void setRid(int rid) {
            this.rid = rid;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
