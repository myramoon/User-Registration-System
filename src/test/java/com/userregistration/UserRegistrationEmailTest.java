package com.userregistration;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class UserRegistrationEmailTest {
    private String emailTest;

    public UserRegistrationEmailTest(String email , boolean expectedResult) {
        this.emailTest = email;
    }

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{ {"abc@yahoo.com", true},
                {"abc-100@yahoo.com", true},
                {"abc.100@yahoo.com", true},
                {"abc111@abc.com", true},
                {"abc-100@abc.net", true},
                {"abc.100@abc.com.au", true},
                {"abc@1.com", true},
                {"abc@gmail.com.com", true},
                {"abc+100@gmail.com", true},
                {"abc", false},
                {"abc@.com.my", false},
                {"abc123@.com", false},
                {"abc123@.com.com", false},
                {"abc123@gmail.a", false},
                {".abc@abc.com", false},
                {"abc()*@gmail.com", false},
                {"abc@%*.com", false},
                {"abc..2002@gmail.com", false},
                {"abc.@gmail.com", false},
                {"abc@abc@gmail.com", false},
                {"abc@gmail.com.1a", false},
                {"abc@gmail.com.aa.au", true}
        });

    }

    @Test
    public void givenEmail_WhenNotProper_ShouldThrowException() {
        UserRegistration validator = new UserRegistration(this.emailTest);
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(UserInputException.class);
            validator.validateEmail();
        } catch (UserInputException e) {
            Assert.assertEquals(UserInputException.exceptionType.ENTERED_IMPROPER , e.type);
        }

    }
}
