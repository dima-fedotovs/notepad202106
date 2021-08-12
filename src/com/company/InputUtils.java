package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
    public static final String TIME_FORMAT = "HH:mm";
    public static final String DATE_FORMAT = "dd.MM.yyyy";
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern(TIME_FORMAT);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    private static final Scanner scanner = new Scanner(System.in);

    public static int askNumber(String message, int min, int max) {
        while (true) {
            try {
                System.out.println(message + ":");
                int answer = scanner.nextInt();
                if (answer < min) {
                    System.out.printf("Number should not be less than %d\n", min);
                } else if (answer > max) {
                    System.out.printf("Number should not be greater than %d\n", max);
                } else {
                    return answer;
                }
            } catch (InputMismatchException ex) {
                var str = scanner.next();
                System.out.printf("You entered %s. But number expected.\n", str);
            }
        }
    }

    public static String askString(String message) {
        System.out.println(message + ":");
        return scanner.next();
    }

    public static LocalTime askTime(String message) {
        var strTime = askString(message + " (" + TIME_FORMAT + ")");
        return LocalTime.parse(strTime, TIME_FORMATTER);
    }

    public static LocalDate askDate(String message) {
        var strDate = askString(message + " (" + DATE_FORMAT + ")");
        return LocalDate.parse(strDate, DATE_FORMATTER);
    }
}
