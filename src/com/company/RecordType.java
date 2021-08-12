package com.company;

public enum RecordType {
    PERSON {
        @Override
        public Record create() {
            return new Person();
        }
    },
    BOOK {
        @Override
        public Record create() {
            return new Book();
        }
    },
    STICKY_NOTE {
        @Override
        public Record create() {
            return new StickyNote();
        }
    },
    ALARM {
        @Override
        public Record create() {
            return new RecurringAlarm();
        }
    },
    REMINDER {
        @Override
        public Record create() {
            return new Reminder();
        }
    };

    public abstract Record create();
}
