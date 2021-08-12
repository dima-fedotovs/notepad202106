package com.company;

import java.time.LocalTime;

public class RecurringAlarm extends StickyNote {
    private LocalTime time;

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
}
