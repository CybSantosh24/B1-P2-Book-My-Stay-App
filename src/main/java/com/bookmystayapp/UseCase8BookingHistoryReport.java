package com.bookmystayapp;

/**
 * ================================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * Demonstrates how confirmed bookings
 * are stored and reported.
 *
 * Maintains an ordered audit trail.
 *
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("Booking History and Reporting\n");

        // Initialize history
        BookingHistory history = new BookingHistory();

        // Simulate confirmed bookings (from UC6)
        history.addReservation(new Reservation("Abhi", "Single"));
        history.addReservation(new Reservation("Subha", "Double"));
        history.addReservation(new Reservation("Vanmathi", "Suite"));

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}