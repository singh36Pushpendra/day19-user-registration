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

        final String EMAIL_PATTERN = "^[a-zA-Z]+[+-]?([.]?[a-zA-Z0-9]{1,})*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}([.][a-zA-Z]{1,})?[,]?$";

        scanner.nextLine();
        System.out.println("Enter Mobile Number: ");
        String mobileNum = scanner.nextLine();

        final String MOBILE_NUM_PATTERN = "^[0-9]{1,3}[ ][6-9][0-9]{9}$";

        System.out.println("Enter Password: ");
        String password = scanner.next();

        final String PASSWORD = "^(?=.{8,})(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]*[@#$%^&()+-_][a-zA-Z0-9]*$";

        System.out.println("Is First Name Valid?: " + validate(FIRST_NAME_PATTERN, firstName));
        System.out.println("Is Last Name Valid?: " + validate(LAST_NAME_PATTERN, lastName));
        System.out.println("Is Email Valid?: " + validate(EMAIL_PATTERN, email));
        System.out.println("Is Mobile No Valid?: " + validate(MOBILE_NUM_PATTERN, mobileNum));
        System.out.println("Is password Valid?: " + validate(PASSWORD,password));

        System.out.println("\nValid Email Samples!");
        System.out.println("Sample 1: abc@yahoo.com, \t" + validate(EMAIL_PATTERN, "abc@yahoo.com,"));
        System.out.println("Sample 2: abc-100@yahoo.com, \t" + validate(EMAIL_PATTERN, "abc-100@yahoo.com,"));
        System.out.println("Sample 3: abc.100@yahoo.com \t" + validate(EMAIL_PATTERN, "abc.100@yahoo.com"));
        System.out.println("Sample 4: abc111@abc.com, \t" + validate(EMAIL_PATTERN, "abc111@abc.com,"));
        System.out.println("Sample 5: abc-100@abc.net, \t" + validate(EMAIL_PATTERN, "abc-100@abc.net,"));
        System.out.println("Sample 6: abc.100@abc.com.au \t" + validate(EMAIL_PATTERN, "abc.100@abc.com.au"));
        System.out.println("Sample 7: abc@1.com, \t" + validate(EMAIL_PATTERN, "abc@1.com,"));
        System.out.println("Sample 8: abc@gmail.com.com \t" + validate(EMAIL_PATTERN, "abc@gmail.com.com"));
        System.out.println("Sample 9: abc+100@gmail.com \t" + validate(EMAIL_PATTERN, "abc+100@gmail.com"));

        System.out.println("\nInvalid Email Samples!");
        System.out.println("Sample 1: abc \t" + validate(EMAIL_PATTERN, "abc"));
        System.out.println("Sample 2: abc@.com.my \t" + validate(EMAIL_PATTERN, "abc@.com.my"));
        System.out.println("Sample 3: abc123@gmail.a \t" + validate(EMAIL_PATTERN, "abc123@gmail.a"));
        System.out.println("Sample 4: abc123@.com \t" + validate(EMAIL_PATTERN, "abc123@.com"));
        System.out.println("Sample 5: abc123@.com.com \t" + validate(EMAIL_PATTERN, "abc123@.com.com"));
        System.out.println("Sample 6: .abc@abc.com \t" + validate(EMAIL_PATTERN, ".abc@abc.com"));
        System.out.println("Sample 7: abc()*@gmail.com \t" + validate(EMAIL_PATTERN, "abc()*@gmail.com"));
        System.out.println("Sample 8: abc@%*.com \t" + validate(EMAIL_PATTERN, "abc@%*.com"));
        System.out.println("Sample 9: abc..2002@gmail.com \t" + validate(EMAIL_PATTERN, "abc..2002@gmail.com"));
        System.out.println("Sample 10: abc.@gmail.com \t" + validate(EMAIL_PATTERN, "abc.@gmail.com"));
        System.out.println("Sample 11: abc@abc@gmail.com \t" + validate(EMAIL_PATTERN, "abc@abc@gmail.com"));
        System.out.println("Sample 12: abc@gmail.com.1a \t" + validate(EMAIL_PATTERN, "abc@gmail.com.1a"));
        System.out.println("Sample 13: abc@gmail.com.aa.au \t" + validate(EMAIL_PATTERN, "abc@gmail.com.aa.au"));
    }
}
