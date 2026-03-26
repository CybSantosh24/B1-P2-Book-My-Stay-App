package com.bookmystayapp;

/**
 * ================================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * Demonstrates safe cancellation and rollback.
 *
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("Booking Cancellation\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Simulate allocation (from UC6)
        CancellationService service = new CancellationService();

        // Register confirmed bookings
        service.registerBooking("Single-1", "Single");

        // Cancel booking
        service.cancelBooking("Single-1", inventory);

        // Show rollback history
        service.showRollbackHistory();

        // Show updated availability
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single"));
    }
}