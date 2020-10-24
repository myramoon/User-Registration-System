package com.userregistration;

public class UserInputException extends Exception {
    enum exceptionType {
        ENTERED_SHORT , ENTERED_LOWERCASEBEGIN , ENTERED_OTHERCHARACTERS ,
        NOTENTERED_SPACE , ENTERED_IMPROPER
    }
    exceptionType type;
    public UserInputException (String error_Msg , exceptionType type) {
        super(error_Msg);
        this.type = type;
    }
}
