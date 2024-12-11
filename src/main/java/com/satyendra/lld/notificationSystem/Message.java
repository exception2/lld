package com.satyendra.lld.notificationSystem;

public abstract class Message {

    NotificationHandler notificationHandler;
    Notification notification;

    public Message(NotificationHandler notificationHandler, Notification notification) {
        this.notificationHandler = notificationHandler;
        this.notification = notification;
    }

    public abstract void sendMessage();
}
