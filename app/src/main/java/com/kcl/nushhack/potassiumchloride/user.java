package com.kcl.nushhack.potassiumchloride;

public class user {

    private String name, email, type;
    private notification[] notifications;

    public notification[] getNotifications() {
        return notifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setNotifications(notification[] notifications) {
        this.notifications = notifications;
    }

    public user(){}

    public user(String email, String name, String type){
        this.name = name;
        this.email = email;
        this.type = type;
    }



}
