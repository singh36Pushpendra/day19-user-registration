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

        System.out.println("Enter Email Id: ");
        String email = scanner.next();

        final String EMAIL_PATTERN = "^[a-zA-Z]+([.][a-zA-Z0-9]{1,})*[@][a-zA-Z]+[.][a-zA-Z]{2,3}([.][a-zA-Z]{1,})*$";

        scanner.nextLine();
        System.out.println("Enter Mobile Number: ");
        String mobileNum = scanner.nextLine();

        final String MOBILE_NUM_PATTERN = "^[0-9]{1,3}[ ][6-9][0-9]{9}$";

        System.out.println("Enter Password: ");
        String password = scanner.next();

        final String PASSWORD = "^.{8,}$";

        System.out.println("Is First Name Valid?: " + validate(FIRST_NAME_PATTERN, firstName));
        System.out.println("Is Last Name Valid?: " + validate(LAST_NAME_PATTERN, lastName));
        System.out.println("Is Email Valid?: " + validate(EMAIL_PATTERN, email));
        System.out.println("Is Mobile No Valid?: " + validate(MOBILE_NUM_PATTERN, mobileNum));
        System.out.println("Is password Valid?: " + validate(PASSWORD,password));

    }
}
