package com.example.Nest_Digital_App_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "employeeLogs")
public class EmployeeLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int empId;

    private String date;

    private String entryDateTime;

    private String exitDateTime;

    public EmployeeLogs() {
    }

    public EmployeeLogs(int id, int empId, String date, String entryDateTime, String exitDateTime) {
        this.id = id;
        this.empId = empId;
        this.date = date;
        this.entryDateTime = entryDateTime;
        this.exitDateTime = exitDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(String entryDateTime) {
        this.entryDateTime = entryDateTime;
    }

    public String getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(String exitDateTime) {
        this.exitDateTime = exitDateTime;
    }
}
