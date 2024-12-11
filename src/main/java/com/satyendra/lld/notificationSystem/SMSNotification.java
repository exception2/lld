package com.satyendra.lld.notificationSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

public class SMSNotification extends Notification {

    private String mobileNo;
    private String body;

    public SMSNotification(int msgId, NotificationType notificationType, String mobileNo, String body) {
        super(msgId, notificationType);
        this.body = body;
        this.mobileNo = mobileNo;
    }
}
