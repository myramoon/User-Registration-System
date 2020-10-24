package com.userregistration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserRegistrationTest {
    @Test
    public void givenName_WhenProper_ShouldReturnTrue() {
        UserRegistration validator = new UserRegistration("Anam");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            boolean result = validator.validateName();
            Assert.assertTrue(result);
        }  catch (UserInputException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenName_WhenStartingWithLowerCase_ShouldThrowException() {
        UserRegistration validator = new UserRegistration("anam");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validateName();

        }  catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.ENTERED_LOWERCASEBEGIN , e.type);
        }
    }

    @Test
    public void givenName_WhenShort_ShouldThrowException() {
        UserRegistration validator = new UserRegistration("An");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validateName();

        }  catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.ENTERED_SHORT , e.type);
        }
    }

    @Test
    public void givenName_WhenIncludingOtherCharacters_ShouldThrowException() {
        UserRegistration validator = new UserRegistration("An4");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validateName();

        }  catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.ENTERED_OTHERCHARACTERS , e.type);
        }
    }

    @Test
    public void givenPhoneNumber_WhenProper_ShouldReturnTrue() {
        UserRegistration validator = new UserRegistration("91 8828297122");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            boolean result = validator.validatePhoneNumber();
            Assert.assertTrue(result);
        }  catch (UserInputException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenPhoneNumber_WhenShort_ShouldThrowException() {
        UserRegistration validator = new UserRegistration("91 68792316");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validatePhoneNumber();
        }  catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.ENTERED_SHORT , e.type);
        }
    }

    @Test
    public void givenPhoneNumber_WhenNotHavingSpaceAfterCCode_ShouldThrowException() {
        UserRegistration validator = new UserRegistration("912561328621");
        try{
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validatePhoneNumber();
        } catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.NOTENTERED_SPACE , e.type);
        }
    }

    @Test
    public void givenPhoneNumber_WhenIncludingOtherCharacters_ShouldThrowException() {
        UserRegistration validator = new UserRegistration("91 23143a8$33");
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validatePhoneNumber();

        }  catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.ENTERED_OTHERCHARACTERS , e.type);
        }
    }
}
