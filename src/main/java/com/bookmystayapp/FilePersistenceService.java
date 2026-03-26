package com.bookmystayapp;

import java.io.*;
import java.util.Map;

/**
 * ================================================================
 * CLASS - FilePersistenceService
 * ================================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * Handles saving and loading inventory data to/from a file.
 *
 * @version 12.0
 */
public class FilePersistenceService {

    /**
     * Saves inventory to file
     *
     * Format:
     * Single=5
     * Double=3
     * Suite=2
     */
    public void saveInventory(RoomInventory inventory, String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            for (Map.Entry<String, Integer> entry :
                    inventory.getRoomAvailability().entrySet()) {

                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }

            System.out.println("Inventory saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving inventory: " + e.getMessage());
        }
    }

    /**
     * Loads inventory from file
     */
    public void loadInventory(RoomInventory inventory, String filePath) {

        File file = new File(filePath);

        // File not found
        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("=");

                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1]);

                    inventory.updateAvailability(roomType, count);
                }
            }

            System.out.println("Inventory loaded successfully.");

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory. Starting fresh.");
        }
    }
}