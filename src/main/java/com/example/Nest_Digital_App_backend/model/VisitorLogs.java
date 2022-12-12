package com.example.Nest_Digital_App_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "visitorLogs")
public class VisitorLogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String purpose;

    private String whomToMeet;

    private String date;

    private String entryDateTime;

    private String exitDateTime;

    public VisitorLogs() {
    }

    public VisitorLogs(int id, String name, String purpose, String whomToMeet, String date, String entryDateTime, String exitDateTime) {
        this.id = id;
        this.name = name;
        this.purpose = purpose;
        this.whomToMeet = whomToMeet;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getWhomToMeet() {
        return whomToMeet;
    }

    public void setWhomToMeet(String whomToMeet) {
        this.whomToMeet = whomToMeet;
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
