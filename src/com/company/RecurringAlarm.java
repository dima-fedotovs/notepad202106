package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class RecurringAlarm extends StickyNote implements Scheduled {
    private LocalTime time;
    private LocalDate dismissedDate;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStrTime() {
        return time.format(InputUtils.TIME_FORMATTER);
    }

    @Override
    public String toString() {
        var tmp = super.toString();
        return tmp + ", time='" + getStrTime() + '\'';
    }

    @Override
    public void askData() {
        super.askData();
        time = InputUtils.askTime("Time");
    }

    @Override
    public boolean isDue(LocalDateTime now) {
        var currentDate = now.toLocalDate();
        if (!currentDate.equals(dismissedDate)) {
            var nowT = now.toLocalTime();
            return nowT.isAfter(time);
        } else {
            return false;
        }
    }

    @Override
    public void dismiss() {
        dismissedDate = LocalDate.now();
    }
}
