package com.mahmoud.dahdouh.eduapp.Model;

import android.util.Log;

public class School {

    private int image;
    private String name;
    private String location;

    public School(int image, String name, String location) {
        this.image = image;
        this.name = name;
        this.location = location;
    }

    public int getImage() {
        System.out.println("image holding");
        Log.e("Main : ", "get image");
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
