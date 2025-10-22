package com.pluralsight;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void testCheckIn_failIfIsOccupiedTrue() {
        // arrange
        Room room = new Room("101", "king", 2);
        room.setOccupied(true); // simulate already occupied Room
        room.setDirty(false); // clean room to isolate test for isOccupied
        // act
        room.checkIn();
        // assert
        assertTrue(room.isOccupied(), "Room should still be occupied.");
        assertFalse(room.isDirty(), "Room should not become dirty if checkIn is blocked.");
    }

    @Test
    void testCheckIn_failIfIsDirtyTrue() {
        // arrange
        Room room = new Room("101", "king", 2);
        room.setOccupied(false);  // simulate unoccupied room to isolate test for isDirty
        room.setDirty(true);    // dirty Room
        // act
        room.checkIn();
        // assert
        assertFalse(room.isOccupied(), "Room should not become occupied if checkIn is blocked.");
        assertTrue(room.isDirty(), "Room should stay dirty.");
    }

    @Test
    void testCleanRoom_failIfIsOccupiedTrue() {
        // arrange
        Room room = new Room("101", "king", 2);
        room.setOccupied(true);  // simulate occupied room
        room.setDirty(true);    // simulate dirty room
        Employee employeeTest = new Employee("12345", "Jason", "housekeeping");
        // act
        room.cleanRoom(employeeTest);
        // assert
        assertTrue(room.isOccupied(), "Room should stay occupied if cleanRoom fails.");
        assertTrue(room.isDirty(), "Room should stay dirty since cleanRoom fails.");
    }

    void testCleanRoom_succeedIfIsDirtyTrue() {
        // arrange
        Room room = new Room("101", "king", 2);
        room.setOccupied(false);  // simulate unoccupied room
        room.setDirty(true);    // simulate dirty room
        Employee employeeTest = new Employee("12345", "Jason", "housekeeping");
        // act
        room.cleanRoom(employeeTest);
        // assert
        assertTrue(room.isOccupied(), "Room should not become occupied.");
        assertFalse(room.isDirty(), "Room should be clean after cleanRoom executes.");
    }


    @Test
    void testCheckOut_failIfIsOccupiedFalse() {
        // arrange
        Room room = new Room("101", "king", 2);
        room.setOccupied(false);  // simulate unoccupied room
        room.setDirty(true);    // simulate dirty room
        // act
        room.checkOut();
        // assert
        assertFalse(room.isOccupied(), "Room should stay unoccupied since checkOut never runs.");
        assertTrue(room.isDirty(), "Room should stay dirty.");
    }

}