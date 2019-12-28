package com.mahmoud.dahdouh.eduapp.Model;

public class User {

    private String username;
    private String email;
    private String profile_img_url;
    private String school_img_url;
    private String account_type;
    private String school_name;
    private String school_location;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile_img_url() {
        return profile_img_url;
    }

    public void setProfile_img_url(String profile_img_url) {
        this.profile_img_url = profile_img_url;
    }

    public String getSchool_img_url() {
        return school_img_url;
    }

    public void setSchool_img_url(String school_img_url) {
        this.school_img_url = school_img_url;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getSchool_location() {
        return school_location;
    }

    public void setSchool_location(String school_location) {
        this.school_location = school_location;
    }
}
