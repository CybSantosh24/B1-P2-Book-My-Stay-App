package com.bookmystayapp;

/**
 * ================================================================
 * CLASS - BookingReportService
 * ================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Generates reports from booking history.
 * Reporting logic is separated from storage.
 *
 * @version 8.0
 */
public class BookingReportService {

    /**
     * Generates booking history report
     *
     * @param history booking history
     */
    public void generateReport(BookingHistory history) {

        System.out.println("Booking History Report\n");

        for (Reservation reservation : history.getConfirmedReservations()) {
            System.out.println("Guest: "
                    + reservation.getGuestName()
                    + ", Room Type: "
                    + reservation.getRoomType());
        }
    }
}