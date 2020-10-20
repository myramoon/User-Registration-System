package com.userregistration;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {

    @Test
    public void givenFirstName_WhenProper_ShouldReturnTrue() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validateFirstName("Anam");
        Assert.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenShort_ShouldReturnFalse() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validateFirstName("An");
        Assert.assertFalse(result);
    }

    @Test
    public void givenFirstName_WhenStartingWithLowerCase_ShouldReturnFalse() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validateFirstName("anam");
        Assert.assertFalse(result);
    }
}

