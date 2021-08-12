package com.company;

import java.time.LocalDate;

public class Reminder extends RecurringAlarm {
    private LocalDate date;

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
}
