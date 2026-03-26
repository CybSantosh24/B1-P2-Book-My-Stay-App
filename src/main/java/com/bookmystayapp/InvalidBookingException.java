package com.bookmystayapp;

/**
 * ================================================================
 * CLASS - InvalidBookingException
 * ================================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * Custom exception for invalid booking scenarios.
 *
 * @version 9.0
 */
public class InvalidBookingException extends Exception {

    /**
     * Creates an exception with message
     *
     * @param message error description
     */
    public InvalidBookingException(String message) {
        super(message);
    }
}