package com.bookmystayapp;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================================
 * CLASS - BookingHistory
 * ================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Maintains a record of confirmed reservations.
 * Provides ordered storage for history and reporting.
 *
 * @version 8.0
 */
public class BookingHistory {

    /** Stores confirmed reservations in order */
    private List<Reservation> confirmedReservations;

    /** Initializes empty booking history */
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /**
     * Adds a confirmed reservation to history
     *
     * @param reservation confirmed booking
     */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /**
     * Returns all confirmed reservations
     *
     * @return list of reservations
     */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}