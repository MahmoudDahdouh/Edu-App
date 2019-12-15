package com.mahmoud.dahdouh.eduapp.Model;

public class Activity {

    private String name;
    private String school;
    private int type;

    public Activity(String name, String school, int type) {
        this.name = name;
        this.school = school;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
