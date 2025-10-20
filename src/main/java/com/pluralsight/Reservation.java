package com.pluralsight;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class Reservation {

    private Room room;
    private String guestName;
    private LocalDate startDate;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(Room room, String guestName, LocalDate startDate, int numberOfNights) {
        this.room = room;
        this.guestName = guestName;
        this.startDate = startDate;
        this.numberOfNights = numberOfNights;
        this.isWeekend = false;
        this.calculateIsWeekend();
    }

    public Room getRoom() {
        return this.room;
    }

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

    public double getPricePerNight() {

        try {
            return (double) this.room.getPricePerNight();
        } catch (NullPointerException e) {
            System.out.printf("Room %s does not have a price set yet.\n", this.getRoom().getRoomNumber());
        }
        return 0;
    }

    public double getReservationTotal() {

        if (!isWeekend) {
            return getPricePerNight() * getNumberOfNights();
        } else {
            double weekendPriceMultiplier = 1.1;
            return getPricePerNight() * getNumberOfNights() * weekendPriceMultiplier;
        }
    }

}
