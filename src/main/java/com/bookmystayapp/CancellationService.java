package com.bookmystayapp;

import java.util.*;

/**
 * ================================================================
 * CLASS - CancellationService
 * ================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * Handles booking cancellations safely.
 * Ensures:
 * - Inventory is restored
 * - Rollback is tracked using Stack (LIFO)
 * - Invalid cancellations are prevented
 *
 * @version 10.0
 */
public class CancellationService {

    /** Stack to track released reservation IDs (LIFO) */
    private Stack<String> releasedReservations;

    /**
     * Maps reservation ID to room type
     * Needed to restore correct inventory
     */
    private Map<String, String> reservationRoomTypeMap;

    /** Constructor */
    public CancellationService() {
        releasedReservations = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking
     *
     * @param reservationId room ID (e.g., Single-1)
     * @param roomType type of room
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels a booking and restores inventory
     *
     * @param reservationId booking ID
     * @param inventory room inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        // Validate existence
        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed: Invalid reservation ID.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Restore inventory
        Map<String, Integer> availability = inventory.getRoomAvailability();
        inventory.updateAvailability(roomType, availability.get(roomType) + 1);

        // Track rollback
        releasedReservations.push(reservationId);

        // Remove from active bookings
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
    }

    /** Displays rollback history */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First)");

        for (int i = releasedReservations.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedReservations.get(i));
        }
    }
}