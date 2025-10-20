package com.pluralsight;

public class Hotel {

    private final String name;
    private final int numberOfSuites;
    private final int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public int getBookedRooms() {
        return bookedRooms;
    }

    public int getAvailableSuites() {
        return this.numberOfSuites - this.bookedSuites;
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.bookedRooms;
    }

    public boolean bookRoom(int numberOfRoomsToBook, boolean isSuite) {

        if (isSuite && getAvailableSuites() <= numberOfRoomsToBook) {
            bookedSuites += numberOfRoomsToBook;
            return true;
        } else if ((!isSuite) && getAvailableRooms() <= numberOfRoomsToBook) {
            bookedRooms += numberOfRoomsToBook;
            return true;
        }
        return false;
    }

}