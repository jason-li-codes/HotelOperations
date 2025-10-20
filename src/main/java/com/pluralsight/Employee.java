package com.pluralsight;

import java.time.Duration;
import java.time.LocalDateTime;

public class Employee {

    private String employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private LocalDateTime punchTime;

    private final double regularHourLimit = 40;
    private final double overtimePayMultiplier = 1.5;

    public Employee(String employeeId, String name, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = 15.50;
        this.hoursWorked = 0.0;
    }

    public Employee(String employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

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

    public double getRegularHours() {
        return Math.min(this.hoursWorked, regularHourLimit);
    }

    public double getOvertimeHours() {
        return Math.max(0.0, this.hoursWorked - regularHourLimit);
    }

    public double getTotalPay() {
        return getRegularHours() * this.payRate + getOvertimeHours() * this.payRate * overtimePayMultiplier;
    }

    public void punchTimeCard(LocalDateTime punchTime) {
        if (this.punchTime == null) {
            this.punchTime = LocalDateTime.now();
        } else {
            this.setHoursWorked(this.getHoursWorked() + Duration.between(this.punchTime, LocalDateTime.now()).toHours());
            this.punchTime = null;
        }
    }

}
