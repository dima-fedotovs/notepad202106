package com.company;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Notepad {
    private final List<Record> records = new ArrayList<>();

    public void createRecord(RecordType type) {
        var rec = type.create();
        rec.askData();
        records.add(rec);
        System.out.println(rec);
    }

    public void listRecords() {
        for (var r : records) {
            System.out.println(r);
        }
    }

//    public void delete(int id) {
//        for (int i = 0; i < records.size(); i++) {
//            var rec = records.get(i);
//            if (rec.getId() == id) {
//                records.remove(i);
//                return;
//            }
//        }
//        System.out.println("Not found");
//    }

    public void delete(int id) {
        var removed = records.removeIf(r -> r.getId() == id);
        if (!removed) {
            System.out.println("Not found");
        }
    }

    public void find(String substr) {
        var tmp = substr.toLowerCase();
        for (Record rec : records) {
            if (rec.contains(tmp)) {
                System.out.println(rec);
            }
        }
    }

    public void listDueRecords(LocalDateTime now) {
        for (var r : records) {
            if (r instanceof Scheduled) {
                var sche = (Scheduled) r;
                if (sche.isDue(now)) {
                    System.out.println(sche);
                }
            }
        }
    }

    public void dismissScheduled(int id) {
        for (var r : records) {
            if (r instanceof Scheduled) {
                var sche = (Scheduled) r;
                if (r.getId() == id) {
                    sche.dismiss();
                    break;
                }
            }
        }
    }
}


/*
create BOOK John Smith 123456
create PERSON Mike Johnson mike@mike.com
create ALARM text 1212
create PERSON Mike1 KKKKKK dfsfsdf
create PERSON Mike9 XXXX dfsfsdf

*/