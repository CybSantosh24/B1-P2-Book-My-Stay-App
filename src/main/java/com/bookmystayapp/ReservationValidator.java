package com.bookmystayapp;

import java.util.Map;

/**
 * ================================================================
 * CLASS - ReservationValidator
 * ================================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * Validates booking requests before processing.
 *
 * @version 9.0
 */
public class ReservationValidator {

    /**
     * Validates booking input
     *
     * @param guestName name of guest
     * @param roomType requested room type
     * @param inventory room inventory
     * @throws InvalidBookingException if validation fails
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory) throws InvalidBookingException {

        // Validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty.");
        }

        // Validate room type
        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (!availability.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected.");
        }

        // Validate availability
        if (availability.get(roomType) <= 0) {
            throw new InvalidBookingException("Selected room type is not available.");
        }
    }
}