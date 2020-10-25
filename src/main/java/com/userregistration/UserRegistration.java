package com.userregistration;
import java.util.regex.Pattern;

public class UserRegistration {
    private static final String REGEX_NAME = "^[A-Z][a-z]{2,}$";
    private static final String REGEX_PHONENUMBER = "^([1-9][0-9]){1}[\\s][1-9][0-9]{9}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+([-\\.\\+\\_]{1}[0-9A-Za-z]+)*@[A-Za-z0-9]+.[a-zA-Z]{2,4}([\\.\\,]{1}[a-z]{2,3}){0,1}$";
    private static final String REGEX_PASSWORD = "^(?=.*[A-Z](?=.*\\d))(?=.*[\\@\\$\\!\\%\\*\\?\\&])[A-Za-z\\d\\@\\$\\!\\%\\*\\?\\&]{8,}$";

    IPattern iPattern ;

    public UserRegistration() {
        iPattern = (input , pattern) -> input.matches(pattern);
    }
    public boolean validateName(String name) throws Exception {
        return iPattern.patternMatcher(name, REGEX_NAME);
    }
    public boolean validateEmailId(String email) throws Exception {
        return iPattern.patternMatcher(email , REGEX_EMAIL);
    }
    public boolean validateMobileNumber(String mobile) throws Exception {
        return iPattern.patternMatcher(mobile , REGEX_PHONENUMBER);
    }
    public boolean validatePassword(String password) throws Exception {
        return iPattern.patternMatcher(password , REGEX_PASSWORD );
    }
}



