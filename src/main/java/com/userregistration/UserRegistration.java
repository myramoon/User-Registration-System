package com.userregistration;

/* Purpose: Validate last name of user */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private String firstName;
    private static final String REGEX_NAME = "^[A-Z]{1}[a-z]{2,}$";

    /* method to validate first name */
    public boolean validateFirstName(String firstName) {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        return pattern.matcher(firstName).matches();
    }

    /* method to validate last name */
    public boolean validateLastName(String lastName) {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        return pattern.matcher(lastName).matches();
    }


}
