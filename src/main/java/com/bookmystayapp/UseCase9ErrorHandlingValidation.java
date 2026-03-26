package com.bookmystayapp;

import java.util.Scanner;

/**
 * ================================================================
 * MAIN CLASS - UseCase9ErrorHandlingValidation
 * ================================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * Demonstrates validation and error handling.
 *
 * @version 9.0
 */
public class UseCase9ErrorHandlingValidation {

    public static void main(String[] args) {

        System.out.println("Booking Validation\n");

        Scanner scanner = new Scanner(System.in);

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        ReservationValidator validator = new ReservationValidator();

        try {
            // User input
            System.out.print("Enter guest name: ");
            String guestName = scanner.nextLine();

            System.out.print("Enter room type (Single/Double/Suite): ");
            String roomType = scanner.nextLine();

            // Validate input
            validator.validate(guestName, roomType, inventory);

            // If valid
            System.out.println("Booking request is valid.");

        } catch (InvalidBookingException e) {

            // Graceful error handling
            System.out.println("Booking failed: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}