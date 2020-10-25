package com.userregistration;
import org.junit.Assert;
import org.junit.Test;

public class UserRegistrationTest {

        //Checking the validity of first name
        @Test
        public void givenFirstName_WhenProper_ReturnsTrue() throws Exception {
            UserRegistration userValidator = new UserRegistration();
            boolean result = userValidator.validateName("Anam");
            Assert.assertEquals(true, result);
        }
        @Test
        public void givenFirstName_WhenImproper_ThrowsException() throws Exception
        {
            try {
                UserRegistration userValidator = new UserRegistration();
                userValidator.validateName("An");
            }
            catch(UserInputException e) {
                Assert.assertEquals("Please enter proper first name", e.getMessage() );
            }
        }
        //Checking the validity of last name
        @Test
        public void givenLastName_WhenProper_ShouldReturnTrue() throws Exception {
            UserRegistration userValidator = new UserRegistration();
            boolean result = userValidator.validateName("Fazal");
            Assert.assertEquals(true, result);
        }
        @Test
        public void givenLastName_WhenImproper_ShouldThrowException() throws Exception {
            try {
                UserRegistration userValidator = new UserRegistration();
                userValidator.validateName("Qwe");
            }
            catch(UserInputException e) {
                Assert.assertEquals("Please enter proper last name", e.getMessage() );
            }
        }

        //Checking the validity of phone number
        @Test
        public void givenPhoneNumber_WhenValid_ShouldReturnTrue() throws Exception {
            UserRegistration userValidator = new UserRegistration();
            boolean result = userValidator.validateMobileNumber("91 9767576865");
            Assert.assertEquals(true, result);
        }

        @Test
        public void givenPhoneNumber_WhenInvalid_ShouldThrowException() throws Exception {
            try {
                UserRegistration userValidator = new UserRegistration();
                userValidator.validateMobileNumber("9869532");
            }catch(UserInputException e) {
                Assert.assertEquals("Please enter correct phone number", e.getMessage() );
            }
        }

        //Check the validity of password
        @Test
        public void givenPassword_WhenValid_ShouldReturnTrue() throws Exception {
            UserRegistration userValidator = new UserRegistration();
            boolean result = userValidator.validatePassword("ASDsde986$");
            Assert.assertEquals(true, result);
        }
        @Test
        public void givenPassword_WhenInvalid_ShouldThrowException() throws Exception {
            try {
                UserRegistration userValidator = new UserRegistration();
                userValidator.validatePassword("hgjui");
            }catch(UserInputException e) {
                Assert.assertEquals("Please enter correct password", e.getMessage() );
            }
        }
}
