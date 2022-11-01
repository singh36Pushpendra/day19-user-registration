package com.user.register;

import junit.framework.Assert;
import org.junit.Test;

public class UserRegistrationTest {

    @Test
    public void validateHappyTest() {
        UserRegistration register = new UserRegistration();
        Assert.assertEquals(true, register.validate(UserRegistration.FIRST_NAME_PATTERN, "Piku"));
        Assert.assertEquals(true, register.validate(UserRegistration.LAST_NAME_PATTERN, "Darbar"));
        Assert.assertEquals(true, register.validate(UserRegistration.MOBILE_NUM_PATTERN, "91 8889579803"));
        Assert.assertEquals(true, register.validate(UserRegistration.EMAIL_PATTERN, "psthakur.1999@gmail.com"));
        Assert.assertEquals(true, register.validate(UserRegistration.PASSWORD, "Darbar$99p"));
    }

    @Test
    public void validateSadTest() {
        UserRegistration register = new UserRegistration();
        Assert.assertEquals(false, register.validate(UserRegistration.FIRST_NAME_PATTERN, "hari"));
        Assert.assertEquals(false, register.validate(UserRegistration.LAST_NAME_PATTERN, "Om"));
        Assert.assertEquals(false, register.validate(UserRegistration.MOBILE_NUM_PATTERN, "7775246728"));
        Assert.assertEquals(false, register.validate(UserRegistration.EMAIL_PATTERN, "abc."));
        Assert.assertEquals(false, register.validate(UserRegistration.PASSWORD, "omkar@22pie"));
    }
}
