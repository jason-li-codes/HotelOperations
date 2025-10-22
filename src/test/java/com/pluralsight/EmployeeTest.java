package com.pluralsight;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testPunchTimeCard_setsCurrentTimeIfNull() {
        // arrange
        Employee employeeTest = new Employee("12345", "Jason", "YearUp");

        // act
        LocalDateTime punchTimeTest = employeeTest.getPunchTime();
        employeeTest.punchTimeCard();
        LocalDateTime punchTimeTestIn = employeeTest.getPunchTime();

        // assert
        // tests LocalDateTime with seconds and nanos set to 0, since it would be impossible for these to
        // be the same while running the test
        assertNull(punchTimeTest);
        assertEquals(punchTimeTestIn.withSecond(0).withNano(0), LocalDateTime.now().withSecond(0).withNano(0));
    }

    @Test
    void testPunchTimeCard_addsToHoursWorkedIfTimeIfTimeIsSet() {
        // arrange
        Employee employeeTest = new Employee("12345", "Jason", "YearUp");

        // act
        employeeTest.setPunchTime(LocalDateTime.now().minusHours(5).minusMinutes(30));
        employeeTest.punchTimeCard();
        LocalDateTime punchTimeTestOut = employeeTest.getPunchTime();

        // assert
        // tests if punchTime is set to null after punching out, and if correct hours are added to hoursWorked
        assertNull(punchTimeTestOut);
        assertEquals(5.5, employeeTest.getHoursWorked());
    }

}