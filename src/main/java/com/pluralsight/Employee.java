package com.pluralsight;

import java.time.Duration;
import java.time.LocalDateTime;

public class Employee {

    // all Employee attributes
    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private LocalDateTime punchTime;

    // final double denoting when regular hours turn into overtime hours
    private final double regularHourLimit = 40;

    // parameterless constructor for new Employees, with default values of minimum wage and 0 hours worked
    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = 15.50;
        this.hoursWorked = 0.0;
        this.punchTime = null;
    }

    // constructor for new Employee with payRate above minium wage, by default no hours worked
    public Employee(String employeeId, String name, String department, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = 0.0;
        this.punchTime = null;
    }

    // constructor with all parameters set
    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.punchTime = null;
    }

    // getters and setters for all attributes
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    // to get regular hours worked, take either hours worked if no overtime hours worked,
    // or full regular hours if overtime is worked
    public double getRegularHours() {
        return Math.min(this.hoursWorked, regularHourLimit);
    }

    // to get overtime hours worked, either return 0 if none worked or take the difference
    // of hours worked and the regular hour threshold
    public double getOvertimeHours() {
        return Math.max(0.0, this.hoursWorked - regularHourLimit);
    }

    // to get total pay, multiply hours worked by pay rate, with a multiplier for overtime pay
    public double getTotalPay() {
        double overtimePayMultiplier = 1.5;
        return getRegularHours() * this.payRate + getOvertimeHours() * this.payRate * overtimePayMultiplier;
    }

    // if no punch time is not set, set it to the current time
    // if a punch time is set, find the difference to track hours worked, and reset punch time
    public LocalDateTime getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(LocalDateTime punchTime) {
        this.punchTime = punchTime;
    }

    // overloaded punchTimeCard method to accept current time or manually entered time
    public void punchTimeCard() {
        if (this.punchTime == null) {
            this.punchTime = LocalDateTime.now();
        } else {
            this.setHoursWorked(this.getHoursWorked() +
                    Duration.between(this.punchTime, LocalDateTime.now()).toMinutes() / 60.0);
            this.punchTime = null;
        }
    }

    public void punchTimeCard(LocalDateTime manualTime) {
        if (this.punchTime == null) {
            this.punchTime = manualTime;
        } else {
            this.setHoursWorked(this.getHoursWorked() +
                    Duration.between(this.punchTime, manualTime).toMinutes() / 60.0);
            this.punchTime = null;
        }
    }

}