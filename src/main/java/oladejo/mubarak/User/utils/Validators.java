package oladejo.mubarak.User.utils;

import oladejo.mubarak.User.exception.UserRegistrationException;

public class Validators {
    public static void isValidPhoneNumber(String phoneNumber){
        for (int i = 0; i < phoneNumber.length(); i++) {
            if(!Character.isDigit(phoneNumber.charAt(i))){
                throw new UserRegistrationException("Phone numbers can only be digits");
            }
            if(phoneNumber.length() != 11){
                throw new UserRegistrationException("Phone number should be eleven digits");
            }
        }

        }
}
