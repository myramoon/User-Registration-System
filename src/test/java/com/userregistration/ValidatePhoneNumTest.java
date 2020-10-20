package com.userregistration;

import org.junit.Assert;
import org.junit.Test;

public class ValidatePhoneNumTest {
    @Test
    public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validatePhoneNumber("917905876656");
        Assert.assertTrue(result);
    }

    @Test
    public void givenPhoneNumber_WhenShort_ShouldReturnFalse() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validatePhoneNumber("123456789");
        Assert.assertFalse(result);
    }
}
