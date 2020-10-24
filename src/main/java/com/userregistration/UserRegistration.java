package com.userregistration;
import java.util.regex.Pattern;

public class UserRegistration {
    private static final String REGEX_NAME = "^[A-Z][a-z]{2,}$";
    private static final String REGEX_PHONENUMBER = "^([1-9][0-9]){1}[\\s][1-9][0-9]{9}$";
    private static final String REGEX_EMAIL = "^[A-Za-z0-9]+([-\\.\\+\\_]{1}[0-9A-Za-z]+)*@[A-Za-z0-9]+.[a-zA-Z]{2,4}([\\.\\,]{1}[a-z]{2,3}){0,1}$";
    private static final String REGEX_PASSWORD1 = "^.{8,}";		//regex pattern for min 8 characters
    private static final String REGEX_PASSWORD2 = ".*[A-Z]{1,}.*";   //regex pattern for min 1 uppercase
    private static final String REGEX_PASSWORD3 = ".*[0-9]{1,}.*";   //regex pattern for min 1 digit
    private static final String REGEX_PASSWORD4 = "[A-Za-z0-9]*[\\!\\@\\#\\$\\%\\&][A-Za-z0-9]*"; //regex pattern for exactly 1 special character

    String input;   //data member of UserRegistration class
    public UserRegistration(String input) {
        this.input = input;
    }

    /* method to validate first and last name */
    public boolean validateName() throws UserInputException {
        Pattern pattern = Pattern.compile(REGEX_NAME);
        try {
            if (pattern.matcher(input).matches())
                return true;
            else {
                if (input.length() < 3)
                    throw new UserInputException("Please enter minimum 3 characters", UserInputException.exceptionType.ENTERED_SHORT);
                else if (Character.isLowerCase(input.charAt(0)))
                    throw new UserInputException("Please begin the name with upper case letter", UserInputException.exceptionType.ENTERED_LOWERCASEBEGIN);
                else
                    throw new UserInputException("Names contain only letters.Please enter proper name.", UserInputException.exceptionType.ENTERED_OTHERCHARACTERS);
            }
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /* method to validate phone number */
    public boolean validatePhoneNumber() throws UserInputException {
        Pattern pattern = Pattern.compile(REGEX_PHONENUMBER);
        try {
            if (pattern.matcher(input).matches())
                return true;
            else {
                if (input.length() < 12)
                    throw new UserInputException("Please enter 2digit country code followed by 10 digit mobile number", UserInputException.exceptionType.ENTERED_SHORT);
                else if (input.charAt(2) != (' '))
                    throw new UserInputException("Please give a space after entering country code.", UserInputException.exceptionType.NOTENTERED_SPACE);
                else
                    throw new UserInputException("Phone numbers contain only digits.Please enter proper number.", UserInputException.exceptionType.ENTERED_OTHERCHARACTERS);
            }
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /* method to validate email */
    public boolean validateEmail() throws UserInputException {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        try {
            if (pattern.matcher(input).matches())
                return true;
            else
                throw new UserInputException("Please enter proper email.Email should be of format [(minimum 1 digit or character)@(minimum 1 digit or character).(2-4 lower case letters)]", UserInputException.exceptionType.ENTERED_IMPROPER);
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /* method to validate password : min 8 characters , min 1 uppercase , min 1 digit , exactly 1 special character */
    public boolean validatePassword() throws UserInputException {
        Pattern pattern1 = Pattern.compile(REGEX_PASSWORD1);
        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD2);
        Pattern pattern3 = Pattern.compile(REGEX_PASSWORD3);
        Pattern pattern4 = Pattern.compile(REGEX_PASSWORD4);
        try {
            if(pattern4.matcher(input).matches())
                if (pattern3.matcher(input).matches())
                    if (pattern2.matcher(input).matches())
                        if(pattern1.matcher(input).matches())
                            return true;
                        else
                            throw new UserInputException("Password should contain minimum 8 characters." , UserInputException.exceptionType.ENTERED_IMPROPER);
                    else
                        throw new UserInputException("Password should contain at least 1 uppercase." , UserInputException.exceptionType.ENTERED_IMPROPER);
                else
                    throw new UserInputException("Password should contain at least 1 digit." , UserInputException.exceptionType.ENTERED_IMPROPER);
            else
                throw new UserInputException("Password should contain exactly 1 special character." , UserInputException.exceptionType.ENTERED_IMPROPER);
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}



