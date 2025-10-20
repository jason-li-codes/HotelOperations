package com.pluralsight;

public class Hotel {

    // all Hotel attributes
    private final String name;
    private final int numberOfSuites;
    private final int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;

    // constructor without booked suites or rooms
    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedRooms = 0;
    }

    // constructor with booked suites or rooms
    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedRooms = bookedRooms;
    }

    // basic getters, no public setters
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

    // getters for available suites/rooms based on number of suites/rooms and booked suites/rooms
    public int getAvailableSuites() {
        return this.numberOfSuites - this.bookedSuites;
    }

    public int getAvailableRooms() {
        return this.numberOfRooms - this.bookedRooms;
    }

    // books rooms if there are available ones available, taking in number and type as parameters
    // returns true if rooms are booked successfully, and false otherwise
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