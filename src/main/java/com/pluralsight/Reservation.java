package com.pluralsight;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class Reservation {

    // all Reservation attributes
    private Room room;
    private String guestName;
    private LocalDate startDate;
    private int numberOfNights;
    private boolean isWeekend;

    // constructor with all parameters except one, which will be calculated with a class method
    public Reservation(Room room, String guestName, LocalDate startDate, int numberOfNights) {
        this.room = room;
        this.guestName = guestName;
        this.startDate = startDate;
        this.numberOfNights = numberOfNights;
        this.isWeekend = false;
        this.calculateIsWeekend();
    }

    // getters and setters
    public Room getRoom() {
        return this.room;
    }

    // includes getRoomNumber so it can be accessed from both Room and Reservation class
    public String getRoomNumber() {
        return this.room.getRoomNumber();
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    // getter for end date depends on startDate and numberOfNights, and could change
    public LocalDate getEndDate() {
        return startDate.plusDays(numberOfNights);
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend() {
        return this.isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

    // checks each night of stay and, if it falls on a weekend, changes isWeekend to true and breaks from loop
    private void calculateIsWeekend() {

        for (int i = 0; i < this.numberOfNights; i++) {
            if (this.startDate.plusDays(i).getDayOfWeek() == DayOfWeek.SATURDAY ||
                    this.startDate.plusDays(i).getDayOfWeek() == DayOfWeek.SUNDAY) {
                this.isWeekend = true;
                break;
            }
        }
    }

    public String getRoomType() {
        return this.room.getType();
    }

    public void setRoomType(String roomType) {
        this.room.setType(roomType);
    }

    // tries getting pricePerNight by calling on Room class with method, with catch for potential null
    public double getPricePerNight() {

        try {
            return (double) this.room.getPricePerNight();
        } catch (NullPointerException e) {
            System.out.printf("Room %s does not have a price set yet.\n", this.getRoom().getRoomNumber());
        }
        return 0;
    }

    // returns total price depending on pricePerNight, numberOfNights, and isWeekend boolean
    public double getReservationTotal() {

        if (!isWeekend) {
            return getPricePerNight() * getNumberOfNights();
        } else {
            double weekendPriceMultiplier = 1.1;
            return getPricePerNight() * getNumberOfNights() * weekendPriceMultiplier;
        }
    }

}
