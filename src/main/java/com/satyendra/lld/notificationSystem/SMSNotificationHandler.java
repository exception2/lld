package com.satyendra.lld.notificationSystem;

public class SMSNotificationHandler implements NotificationHandler {
    @Override
    public void send(Notification notification) {
        System.out.println("Sent SMS notification");
    }
}
