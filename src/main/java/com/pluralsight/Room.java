package com.pluralsight;

public class Room {

    private String roomNumber;
    private String type;
    private int numberOfBeds;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(String type, int numberOfBeds) {
        this.type = type;
        this.numberOfBeds = numberOfBeds;
        this.isOccupied = false;
        this.isDirty = true;
    }

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

    public boolean isAvailable() {
        return !(this.isDirty || this.isOccupied);
    }

    public Double getPricePerNight() {
        return switch (this.type) {
            case "king" -> 139.00;
            case "double" -> 124.00;
            default -> null;
        };
    }

    public void checkIn() {
        if (this.isOccupied) {
            System.out.printf("Room %s is occupied and cannot be checked into.\n", roomNumber);
        } else if (this.isDirty) {
            System.out.printf("Room %s is dirty and cannot be checked into.\n", roomNumber);
        } else{
            this.setOccupied(true);
            this.setDirty(true);
        }
    }

    public void cleanRoom(Employee employee) {
        if (!this.isDirty) {
            System.out.printf("%s is not dirty and does not need cleaning.\n", roomNumber);
        } else {
            this.setDirty(false);
        }
    }

    public void checkOut() {
        if (!this.isOccupied) {
            System.out.printf("%s is not occupied and does not to be checked out of.", roomNumber);
        }
        else {
            this.setOccupied(false);
        }
    }

}
