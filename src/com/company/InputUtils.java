package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {
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

}
