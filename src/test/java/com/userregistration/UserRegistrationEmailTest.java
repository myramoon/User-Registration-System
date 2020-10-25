package com.userregistration;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class UserRegistrationEmailTest {
    private String emailTest;
    private boolean expectedResult;

    public UserRegistrationEmailTest(String email , boolean expectedResult) {
        this.emailTest = email;
        this.expectedResult = expectedResult;
    }

    @SuppressWarnings("rawtypes")
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
    public void givenEmail_ShouldReturnAsPerParameterizedResult() throws Exception {
        try {
            UserRegistration userValidator = new UserRegistration();
            userValidator.validateEmailId(this.emailTest);
        }catch(UserInputException e) {
            Assert.assertEquals("Please enter correct email" , e.getMessage());
        }
    }
}
