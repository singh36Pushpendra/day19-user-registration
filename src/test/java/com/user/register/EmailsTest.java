package com.user.register;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@RunWith(Parameterized.class)
public class EmailsTest {
    String regex;
    String input;
    boolean matched;

    public EmailsTest(String regex, String input, boolean matched) {
        this.regex = regex;
        this.input = input;
        this.matched = matched;
    }

    @Test
    public void validateTest() {
        UserRegistration register = new UserRegistration();
        Assert.assertEquals(matched, register.validate(regex, input));
    }

    @Parameterized.Parameters
    public static Collection addEmails() {
        Object[][] emails = {
                {UserRegistration.EMAIL_PATTERN, "abc@yahoo.com,", true},
                {UserRegistration.EMAIL_PATTERN, "abc-100@yahoo.com,", true},
                {UserRegistration.EMAIL_PATTERN, "abc.100@yahoo.com", true},
                {UserRegistration.EMAIL_PATTERN, "abc111@abc.com,", true},
                {UserRegistration.EMAIL_PATTERN, "abc-100@abc.net,", true},
                {UserRegistration.EMAIL_PATTERN, "abc.100@abc.com.au", true},
                {UserRegistration.EMAIL_PATTERN, "abc@1.com,", true},
                {UserRegistration.EMAIL_PATTERN, "abc@gmail.com.com", true},
                {UserRegistration.EMAIL_PATTERN, "abc+100@gmail.com", true},
                {UserRegistration.EMAIL_PATTERN,  "abc", false},
                {UserRegistration.EMAIL_PATTERN,  "abc@.com.my", false},
                {UserRegistration.EMAIL_PATTERN,  "abc123@gmail.a", false},
                {UserRegistration.EMAIL_PATTERN,  "abc123@.com", false},
                {UserRegistration.EMAIL_PATTERN,  "abc123@.com.com", false},
                {UserRegistration.EMAIL_PATTERN,  ".abc@abc.com", false},
                {UserRegistration.EMAIL_PATTERN,  "abc()*@gmail.com", false},
                {UserRegistration.EMAIL_PATTERN,  "abc@%*.com", false},
                {UserRegistration.EMAIL_PATTERN,  "abc..2002@gmail.com", false},
                {UserRegistration.EMAIL_PATTERN,  "abc.@gmail.com", false},
                {UserRegistration.EMAIL_PATTERN,  "abc@abc@gmail.com", false},
                {UserRegistration.EMAIL_PATTERN,  "abc@gmail.com.1a", false},
                {UserRegistration.EMAIL_PATTERN,  "abc@gmail.com.aa.au", false}
        };

        return Arrays.asList(emails);
    }
}
