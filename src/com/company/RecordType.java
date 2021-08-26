package com.company;

import java.util.Locale;
import java.util.Set;

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

        @Override
        public boolean matches(String str) {
            return super.matches(str) || "note".equalsIgnoreCase(str);
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
    public boolean matches(String str) {
        return this.name().equalsIgnoreCase(str);
    }

    public static RecordType findByName(String str) {
        for (var rt : RecordType.values()) {
            if (rt.matches(str)) {
                return rt;
            }
        }
        throw new IllegalArgumentException(str);
    }
}
