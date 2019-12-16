package com.mahmoud.dahdouh.eduapp.Model;

public class Message {
    private String school_name;
    private int nof_msgs;
    private String username;
    private String msg;
    private String time;
    private int img_user;

    public Message(String school_name, int nof_msgs, String username, String msg, String time, int img_user) {
        this.school_name = school_name;
        this.nof_msgs = nof_msgs;
        this.username = username;
        this.msg = msg;
        this.time = time;
        this.img_user = img_user;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public int getNof_msgs() {
        return nof_msgs;
    }

    public void setNof_msgs(int nof_msgs) {
        this.nof_msgs = nof_msgs;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImg_user() {
        return img_user;
    }

    public void setImg_user(int img_user) {
        this.img_user = img_user;
    }
}
