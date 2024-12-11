package com.satyendra.lld.notificationSystem;

public class VoiceMessage extends Message {
    public VoiceMessage(NotificationHandler notificationHandler, Notification notification) {
        super(notificationHandler, notification);
    }

    @Override
    public void sendMessage() {
        // write method to generate message
        notificationHandler.send(notification);
    }

}
