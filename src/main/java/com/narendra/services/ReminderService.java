package com.narendra.services;

import com.narendra.dto.Reminder;
import com.narendra.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Autowired
    private NotificationService notificationService;

    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }

    @Scheduled(fixedRate = 60000) // Check every minute
    public void checkAndSendReminders() {
        List<Reminder> dueReminders = reminderRepository.findByNotifiedFalseAndReminderTimeBefore(new Date());
        for (Reminder reminder : dueReminders) {
            notificationService.sendNotification(reminder);
            reminder.setNotified(true);
            reminderRepository.save(reminder);
        }
    }
}
