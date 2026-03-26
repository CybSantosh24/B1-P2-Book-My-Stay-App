package com.bookmystayapp;

/**
 * ================================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ================================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * Demonstrates saving and restoring inventory.
 *
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery\n");

        String filePath = "inventory.txt";

        // Initialize components
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // Load saved data
        persistenceService.loadInventory(inventory, filePath);

        // Display current inventory
        System.out.println("\nCurrent Inventory:");
        inventory.getRoomAvailability().forEach((type, count) ->
                System.out.println(type + ": " + count)
        );

        // Simulate update (optional)
        inventory.updateAvailability("Single", 5);

        // Save state
        persistenceService.saveInventory(inventory, filePath);
    }
}