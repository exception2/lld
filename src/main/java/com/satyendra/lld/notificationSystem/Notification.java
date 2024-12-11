package com.satyendra.lld.notificationSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Notification {

    private int msgId;
    private NotificationType notificationType;


}
