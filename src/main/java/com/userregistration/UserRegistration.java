package com.userregistration;

/* Purpose: Validate first name of user */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private String firstName;
    private static final String REGEX_FIRST_NAME = "^[A-Z]{1}[a-z]{2,}$";

    /* method to validate first name */
    public boolean validateFirstName(String firstName) {
        Pattern pattern = Pattern.compile(REGEX_FIRST_NAME);
        return pattern.matcher(firstName).matches();
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        UserRegistration validator = new UserRegistration();
        System.out.println("Enter first name");
        validator.firstName = scan.next();
        validator.validateFirstName(validator.firstName);
    }

}
