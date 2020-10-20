package com.userregistration;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {

    @Test
    public void givenLastName_WhenProper_ShouldReturnTrue() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validateLastName("Anam");
        Assert.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenShort_ShouldReturnFalse() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validateLastName("An");
        Assert.assertFalse(result);
    }

    @Test
    public void givenLastName_WhenStartingWithLowerCase_ShouldReturnFalse() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validateLastName("anam");
        Assert.assertFalse(result);
    }


}

