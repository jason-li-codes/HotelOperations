package com.pluralsight;

import java.util.Objects;

public class Room {

    // all Room attributes
    private String roomNumber;
    private String type;
    private int numberOfBeds;
    private boolean isOccupied;
    private boolean isDirty;

    // constructor for Room, with room type and number of beds required, and default values for rest of attributes
    public Room(String roomNumber, String type, int numberOfBeds) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.numberOfBeds = numberOfBeds;
        this.isOccupied = false;
        this.isDirty = true;
    }

    // getters and setters for all attributes, including booleans
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isDirty() {
        return isDirty;
    }

    public void setDirty(boolean dirty) {
        isDirty = dirty;
    }

    // new boolean method that depends on isDirty and isOccupied booleans, not an attribute itself
    public boolean isAvailable() {
        return !(this.isDirty || this.isOccupied);
    }

    // returns price per night based on room type, with default null if price is not set
    public double getPricePerNight() {
        if (Objects.equals(type, "double")) {
            return 124.00;
        } else {
            return 139.00;
        }
    }

    // when you check in, sets isOccupied and isDirty to true, printing messages if room is unavailable
    public void checkIn() {
        if (this.isOccupied) {
            System.out.printf("Room %s is occupied and cannot be checked into.\n", roomNumber);
        } else if (this.isDirty) {
            System.out.printf("Room %s has not been cleaned and cannot be checked into.\n", roomNumber);
        } else{
            this.setOccupied(true);
            this.setDirty(true);
        }
    }

    // requires Employee to clean room, printing message if room is already clean
    public void cleanRoom(Employee employee) {
        if (this.isOccupied) {
            System.out.printf("Room %s is occupied and cannot be cleaned.", roomNumber);
        } else if (!this.isDirty) {
            System.out.printf("Room %s is not dirty and does not need cleaning.\n", roomNumber);
        } else {
            this.setDirty(false);
        }
    }

    // when you check out, set isOccupied to false, printing message if room was not occupied
    public void checkOut() {
        if (!this.isOccupied) {
            System.out.printf("Room %s is not occupied and does not to be checked out of.", roomNumber);
        } else {
            this.setOccupied(false);
        }
    }

}