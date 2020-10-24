package com.userregistration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UserRegistrationPasswordTest {
    private String passwordTest;

    public UserRegistrationPasswordTest(String password, boolean expectedResult) {
        this.passwordTest = password;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{{"Abgth1x!c", true},
                {"AAHJJcwhq1$", true},
                {"abc!3A", false},     //less than 8 characters
                {"abcdef!4h", false},  // no upper case
                {"abcdef!Ax", false},  // no digit
                {"abcdefG1", false},   // no special character
        });

    }

    @Test
    public void givenPassword_WhenNotProper_ShouldThrowException() {
        UserRegistration validator = new UserRegistration(this.passwordTest);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validatePassword();
        } catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.ENTERED_IMPROPER , e.type);
        }
    }

}