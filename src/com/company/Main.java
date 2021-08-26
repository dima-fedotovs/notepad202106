package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    private static final Notepad notepad = new Notepad();

    public static void main(String[] args) {
        var running = true;

        while (running) {
            var cmd = InputUtils.askString("enter command\n(enter \"help\" for help)");
            switch (cmd) {
                case "exit":
                    running = false;
                    break;
                case "help":
                    showHelp();
                    break;
                case "create":
                    createRecord();
                    break;
                case "list":
                case "ls":
                    listRecords();
                    break;
                case "delete":
                case "del":
                    deleteRecord();
                    break;
                case "find":
                case "search":
                    findRecord();
                    break;
                case "due":
                    listDueRecords();
                    break;
                case "dismiss":
                    dismissScheduled();
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
        System.out.println("Good bye");
    }

    private static void dismissScheduled() {
        var id = InputUtils.askNumber("Enter record ID to dismiss", 1, Integer.MAX_VALUE);
        notepad.dismissScheduled(id);
    }

    private static void listDueRecords() {
        var now = LocalDateTime.now();
        notepad.listDueRecords(now);
    }

    private static void findRecord() {
        var substr = InputUtils.askString("What to find?");
        notepad.find(substr);
    }

    private static void deleteRecord() {
        var id = InputUtils.askNumber("Enter record ID to delete", 1, Integer.MAX_VALUE);
        notepad.delete(id);
    }

    private static void listRecords() {
        notepad.listRecords();
    }

    private static void createRecord() {
        System.out.println("Supported types:");
        for(var t : RecordType.values()) {
            System.out.println("   " + t);
        }
        var strType = InputUtils.askString("Enter record type");
        var type = RecordType.findByName(strType);

        notepad.createRecord(type);

        System.out.println("created");
    }

    private static void showHelp() {
        System.out.println("This is very useful help!");
    }
}
