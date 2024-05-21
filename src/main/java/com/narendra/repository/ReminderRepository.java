package com.narendra.repository;

import com.narendra.dto.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
    List<Reminder> findByNotifiedFalseAndReminderTimeBefore(Date currentTime);
}
