package com.bookmystayapp;

/**
 * ================================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ================================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class demonstrates how room availability
 * is managed using a centralized inventory.
 *
 * Room objects are used to retrieve pricing
 * and room characteristics.
 *
 * No booking or search logic is introduced here.
 *
 * @version 3.1
 */
public class UseCase3InventorySetup {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Hotel Inventory Setup\n");

        // Create room domain objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display room details + availability
        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available: "
                + inventory.getRoomAvailability().get("Single") + "\n");

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: "
                + inventory.getRoomAvailability().get("Double") + "\n");

        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available: "
                + inventory.getRoomAvailability().get("Suite") + "\n");

        // Demonstrate update
        System.out.println("Updating Single Room Availability...\n");
        inventory.updateAvailability("Single", 4);

        inventory.displayInventory();
    }
}