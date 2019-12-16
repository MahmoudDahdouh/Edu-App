package com.mahmoud.dahdouh.eduapp.Model;

public class Notification {
    private String schoolName;
    private String notificationTitle;
    private String notificationTime;
    private String notificationDescription;

    public Notification(String schoolName, String notificationTitle, String notificationTime, String notificationDescription) {
        this.schoolName = schoolName;
        this.notificationTitle = notificationTitle;
        this.notificationTime = notificationTime;
        this.notificationDescription = notificationDescription;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public String getNotificationDescription() {
        return notificationDescription;
    }

    public void setNotificationDescription(String notificationDescription) {
        this.notificationDescription = notificationDescription;
    }
}
