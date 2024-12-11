package com.satyendra.lld.notificationSystem;

public class NotificationClient {
    public static void main(String[] args) {
        Message message = new TextMessage(new SMSNotificationHandler(), new SMSNotification(1, NotificationType.SMS, "12345", "this is message"));
        message.sendMessage();
    }
}
