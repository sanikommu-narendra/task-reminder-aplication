package com.narendra.services;

import com.narendra.dto.Reminder;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public void sendNotification(Reminder reminder) {
        // Implementation for sending notifications
        // This could be via email, push notification, etc.
        System.out.println("Sending notification for reminder: " + reminder.getReminderId());
    }
}
