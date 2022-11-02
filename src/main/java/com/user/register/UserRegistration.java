package com.user.register;

import java.util.Scanner;
import java.util.regex.Pattern;

public class UserRegistration {

    static final String FIRST_NAME_PATTERN = "^[A-Z][a-z]{2,}$";
    static final String LAST_NAME_PATTERN = FIRST_NAME_PATTERN;
    static final String EMAIL_PATTERN = "^[a-zA-Z]+([.+-]?[a-zA-Z0-9]{1,})*[@][a-zA-Z0-9]+[.][a-zA-Z]{2,3}([.][a-zA-Z]{2,3})?[,]?$";
    static final String MOBILE_NUM_PATTERN = "^[0-9]{1,3}[ ][6-9][0-9]{9}$";
    static final String PASSWORD = "^(?=.{8,})(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]*[@#$%^&()+-_][a-zA-Z0-9]*$";

    static boolean validate(String regex, String input) {
        return Pattern.compile(regex).matcher(input).matches();
    }

    public static void main(String[] args) {
        IValidateUser iValidateUser = (re, in) -> Pattern.compile(re).matcher(in).matches();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        String firstName = scanner.next();

        System.out.println("Enter last Name: ");
        String lastName = scanner.next();

        System.out.println("Enter Email Id: ");
        String email = scanner.next();

        scanner.nextLine();
        System.out.println("Enter Mobile Number: ");
        String mobileNum = scanner.nextLine();

        System.out.println("Enter Password: ");
        String password = scanner.next();

        if (iValidateUser.validate(FIRST_NAME_PATTERN, firstName))
            System.out.println("Is First Name Valid?: " + iValidateUser.validate(FIRST_NAME_PATTERN, firstName));
        else
            throw new UserRegistrationException("Invalid User Detail: First Name" +
                    " should have atleast 3 length and starts with capital letter!");

        if (iValidateUser.validate(LAST_NAME_PATTERN, lastName))
            System.out.println("Is Last Name Valid?: " + iValidateUser.validate(LAST_NAME_PATTERN, lastName));
        else
            throw new UserRegistrationException("Invalid User Detail: Last Name" +
                    " should have atleast 3 length and starts with capital letter!");

        if (iValidateUser.validate(EMAIL_PATTERN, email))
            System.out.println("Is Email Valid?: " + iValidateUser.validate(EMAIL_PATTERN, email));
        else
            throw new UserRegistrationException("Invalid User Detail: Email" +
                    " should have format like 'abc.xyz@bl.co.in'!");

        if (iValidateUser.validate(MOBILE_NUM_PATTERN, mobileNum))
            System.out.println("Is Mobile No Valid?: " + iValidateUser.validate(MOBILE_NUM_PATTERN, mobileNum));
        else
            throw new UserRegistrationException("Invalid User Detail: Mobile Number" +
                    " should have country code and a 10 digit no. followed by a space!");

        if (iValidateUser.validate(PASSWORD,password))
            System.out.println("Is password Valid?: " + iValidateUser.validate(PASSWORD,password));
        else
            throw new UserRegistrationException("Invalid User Detail: Password should have atleast 1 capital, " +
                    "1 Digit, 1 Special Character and atleast have length Eight!");

        System.out.println("\nValid Email Samples!");
        String[] validEmails = {
            "abc@yahoo.com,",
            "abc-100@yahoo.com,",
            "abc.100@yahoo.com",
            "abc111@abc.com,",
            "abc-100@abc.net,",
            "abc.100@abc.com.au",
            "abc@1.com,",
            "abc@gmail.com.com",
            "abc+100@gmail.com"
        };

        for (String validEmail : validEmails)
            System.out.println("Email " + validEmail + " valid?: " + iValidateUser.validate(EMAIL_PATTERN, validEmail));

        System.out.println("\nInvalid Email Samples!");
        String[] invalidEmails = {
            "abc",
            "abc@.com.my",
            "abc123@gmail.a",
            "abc123@.com",
            "abc123@.com.com",
            ".abc@abc.com",
            "abc()*@gmail.com",
            "abc@%*.com",
            "abc..2002@gmail.com",
            "abc.@gmail.com",
            "abc@abc@gmail.com",
            "abc@gmail.com.1a",
            "abc@gmail.com.aa.au"
        };
        System.out.println();
        for (String invalidEmail :
                invalidEmails) {
            System.out.println("Email " + invalidEmail + " valid?: " + iValidateUser.validate(EMAIL_PATTERN, invalidEmail));
        }
    }
}
