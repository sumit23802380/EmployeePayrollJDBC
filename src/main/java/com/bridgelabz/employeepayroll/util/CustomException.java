package com.bridgelabz.employeepayroll.util;

/**
 * @desc : CustomException Class extends Exception class
 */
public class CustomException extends Exception {
    /**
     * @desc : Method to pass the message to base class Exception
     * @param : message
     */
    public CustomException(String message) {
        super(message);
    }
}
