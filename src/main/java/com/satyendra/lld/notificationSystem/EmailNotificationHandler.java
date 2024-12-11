package com.satyendra.lld.notificationSystem;

public class EmailNotificationHandler implements NotificationHandler {
    @Override
    public void send(Notification notification) {
        System.out.println("Sent email notification");
    }
}
