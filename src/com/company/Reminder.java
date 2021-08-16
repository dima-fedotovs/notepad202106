package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder extends RecurringAlarm implements Scheduled {
    private LocalDate date;
    private boolean active = true;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStrDate() {
        return date.format(InputUtils.DATE_FORMATTER);
    }

    @Override
    public String toString() {
        var tmp = super.toString();
        return tmp + ", date='" + getStrDate() + '\'';
    }

    @Override
    public void askData() {
        super.askData();
        date = InputUtils.askDate("Date");
    }

    @Override
    public boolean isDue(LocalDateTime now) {
        if (active) {
            var myDT = date.atTime(getTime());
            return now.isAfter(myDT);
        } else {
            return false;
        }
    }

    @Override
    public void dismiss() {
        active = false;
    }

}
