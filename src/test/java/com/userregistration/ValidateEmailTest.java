package com.userregistration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class ValidateEmailTest {
    private String emailTest;
    private boolean expectedResult;

    public ValidateEmailTest(String email , boolean expectedResult) {
        this.emailTest = email;
        this.expectedResult =expectedResult;
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
                {"abc@gmail.com.aa.au", false}
        });

    }

    @Test
    public void givenEmail_ShouldReturnAsPerParameterizedResult() {
        UserRegistration validator = new UserRegistration();
        boolean result = validator.validateEmail(this.emailTest);
        Assert.assertEquals(this.expectedResult , result);
    }

}
