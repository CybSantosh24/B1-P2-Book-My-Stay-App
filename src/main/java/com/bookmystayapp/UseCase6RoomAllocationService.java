package com.bookmystayapp;

/**
 * ================================================================
 * MAIN CLASS - UseCase6RoomAllocationService
 * ================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * FIFO queue is processed and
 * inventory is updated immediately.
 *
 * @version 6.0
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("Room Allocation Processing\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Initialize queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add booking requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        // Allocation service
        RoomAllocationService allocationService = new RoomAllocationService();

        // Process FIFO queue
        while (queue.hasPendingRequests()) {
            Reservation reservation = queue.getNextRequest();
            allocationService.allocateRoom(reservation, inventory);
        }
    }
}