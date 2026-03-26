package com.bookmystayapp;

/**
 * ================================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ================================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * Demonstrates how optional services
 * can be added to a confirmed reservation.
 *
 * Services do NOT affect booking or inventory.
 *
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("Add-On Service Selection\n");

        // Assume this comes from UC6 (allocated room ID)
        String reservationId = "Single-1";

        // Create service manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService spa = new AddOnService("Spa", 800.0);
        AddOnService pickup = new AddOnService("Airport Pickup", 200.0);

        // Attach services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        manager.addService(reservationId, pickup);

        // Display result
        System.out.println("Reservation ID: " + reservationId);

        double totalCost = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Total Add-On Cost: " + totalCost);
    }
}