package com.bookmystayapp;

import java.util.*;

/**
 * ================================================================
 * CLASS - AddOnServiceManager
 * ================================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * Manages optional services associated with reservations.
 * Supports multiple services per reservation.
 *
 * @version 7.0
 */
public class AddOnServiceManager {

    /**
     * Maps reservation ID to selected services
     * Key   -> Reservation ID
     * Value -> List of services
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /** Initializes the service manager */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Adds a service to a reservation
     *
     * @param reservationId reservation ID
     * @param service add-on service
     */
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /**
     * Calculates total service cost for a reservation
     *
     * @param reservationId reservation ID
     * @return total cost
     */
    public double calculateTotalServiceCost(String reservationId) {

        List<AddOnService> services =
                servicesByReservation.getOrDefault(reservationId, new ArrayList<>());

        double total = 0;

        for (AddOnService service : services) {
            total += service.getCost();
        }

        return total;
    }
}