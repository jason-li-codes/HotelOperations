package com.pluralsight;

public class Room {

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

}
