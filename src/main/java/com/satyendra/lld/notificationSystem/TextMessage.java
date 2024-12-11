package com.satyendra.lld.notificationSystem;

public class TextMessage extends Message {
    public TextMessage(NotificationHandler notificationHandler, Notification notification) {
        super(notificationHandler, notification);
    }

    @Override
    public void sendMessage() {
        notificationHandler.send(notification);
    }
}
