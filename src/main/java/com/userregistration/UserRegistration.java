package com.userregistration;

/* Purpose: Validate last name of user */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private String firstName;
    private static final String REGEX_NAME = "^[A-Z]{1}[a-z]{2,}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+([-\\.\\+\\_]{1}[0-9A-Za-z]+)*@[A-Za-z0-9]+.[a-zA-Z]{2,4}([\\.\\,]{1}[a-z]{2,3}){0,1}$";
    private static final String REGEX_PASSWORD = "^(?=.*[A-Z](?=.*\\d))(?=.*[\\@\\$\\!\\%\\*\\?\\&])[A-Za-z\\d\\@\\$\\!\\%\\*\\?\\&]{8,}$";

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
    /* method to validate email */
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        return pattern.matcher(email).matches();
    }

    /* method to validate password : min 8 characters , min 1 uppercase , min 1 digit , exactly 1 special character */
    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(REGEX_PASSWORD);
        return pattern.matcher(password).matches();
    }


}
