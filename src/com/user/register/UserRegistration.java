package com.user.register;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {

    private static boolean validate(String regex, String input) {
        return Pattern.compile(regex).matcher(input).matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();

        final String FIRST_NAME_PATTERN = "^[A-Z][a-z]{2,}$";

        System.out.println("Enter last Name: ");
        String lastName = scanner.next();

        final String LAST_NAME_PATTERN = FIRST_NAME_PATTERN;

        System.out.println("Is First Name Valid?: " + validate(FIRST_NAME_PATTERN, firstName));
        System.out.println("Is Last Name Valid?: " + validate(LAST_NAME_PATTERN, lastName));

    }
}
