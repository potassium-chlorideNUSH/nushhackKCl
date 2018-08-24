package com.kcl.nushhack.potassiumchloride;

abstract class user {
    String name, email;
    int id;

    public notification[] getNotifications() {
        return notifications;
    }

    public void setNotifications(notification[] notifications) {
        this.notifications = notifications;
    }

    notification[] notifications;

}
