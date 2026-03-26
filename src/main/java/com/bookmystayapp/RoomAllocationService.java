package com.bookmystayapp;

import java.util.*;

/**
 * ================================================================
 * CLASS - RoomAllocationService
 * ================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class confirms booking requests and assigns rooms.
 *
 * It ensures:
 * - Unique room IDs
 * - Inventory is updated immediately
 * - No double booking occurs
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /** Stores all allocated room IDs to prevent duplicates */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs grouped by room type
     * Key   -> Room Type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /** Initializes allocation tracking structures */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms booking request by allocating a room
     *
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check availability
        if (availability.get(roomType) == null || availability.get(roomType) <= 0) {
            System.out.println("No rooms available for Guest: "
                    + reservation.getGuestName()
                    + ", Requested: " + roomType);
            return;
        }

        // Generate unique Room ID
        String roomId = generateRoomId(roomType);

        // Store in allocated set
        allocatedRoomIds.add(roomId);

        // Track by room type
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory (CRITICAL STEP)
        inventory.updateAvailability(roomType, availability.get(roomType) - 1);

        // Confirm booking
        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    /**
     * Generates a unique room ID
     *
     * Example: Single-1, Single-2
     */
    private String generateRoomId(String roomType) {

        int count = assignedRoomsByType
                .getOrDefault(roomType, new HashSet<>())
                .size() + 1;

        String roomId = roomType + "-" + count;

        // Ensure uniqueness (extra safety)
        while (allocatedRoomIds.contains(roomId)) {
            count++;
            roomId = roomType + "-" + count;
        }

        return roomId;
    }
}