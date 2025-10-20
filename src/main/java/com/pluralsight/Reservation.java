package com.pluralsight;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class Reservation {

    private Room roomNumber;
    private String guestName;
    private LocalDate startDate;
    private int numberOfNights;
    private boolean isWeekend;

    private final double weekendPriceMultiplier = 1.1;

    public Reservation(Room roomNumber, String guestName, LocalDate startDate, int numberOfNights) {
        this.roomNumber = roomNumber;
        this.guestName = guestName;
        this.startDate = startDate;
        this.numberOfNights = numberOfNights;
        this.isWeekend = false;
        this.calculateIsWeekend();
    }

    public Room getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Room roomNumber) {
        this.roomNumber = roomNumber;
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
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }

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
        return this.roomNumber.getType();
    }

    public void setRoomType(String roomType) {
        this.roomNumber.setType(roomType);
    }

    public double getPricePerNight() {

        try {
            return (double) this.roomNumber.getPricePerNight();
        } catch (NullPointerException e) {
            System.out.println("This room does not have a price set yet.");
        }
        return 0;
    }

    public double getReservationTotal() {

        double total = 0;
        if (!isWeekend) {
            return getPricePerNight() * getNumberOfNights();
        } else {
            return getPricePerNight() * getNumberOfNights() * weekendPriceMultiplier;
        }
    }

}
