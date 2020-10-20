package com.userregistration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class ValidatePasswordTest {
    private String passwordTest;
    private boolean expectedResult;

    public ValidatePasswordTest(String password , boolean expectedResult) {
        this.passwordTest = password;
        this.expectedResult =expectedResult;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{ {"Abgth1x!c", true},
                {"AAHJJcwhq1$", true},
                {"abc", false},     //less than 8 characters, no upper case, no digit , no special character
                {"abcdefgh", false},    // no upper case, no digit ,no special character
                {"abcdefgH", false}, // no digit , no special character
                {"abcdefG1", false}, // no special character
                {"$ajwbD1",false}   // less that 8 characters
        });

    }

    @Test
    public void givenEmail_ShouldReturnAsPerParameterizedResult() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validatePassword(this.passwordTest);
        Assert.assertEquals(this.expectedResult , result);
    }

}
