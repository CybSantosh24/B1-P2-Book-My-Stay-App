package com.bookmystayapp;

/**
 * ================================================================
 * CLASS - ConcurrentBookingProcessor
 * ================================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * Processes booking requests concurrently
 * with thread-safe access to shared resources.
 *
 * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {

    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService) {

        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            // 🔒 Critical Section (Thread-safe queue access)
            synchronized (bookingQueue) {
                if (!bookingQueue.hasPendingRequests()) {
                    break;
                }
                reservation = bookingQueue.getNextRequest();
            }

            // 🔒 Critical Section (Allocation + Inventory update)
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}