package com.example.Nest_Digital_App_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "leaveCount")
public class LeaveCount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int empId;

    private String year;

    private int casualLeave;

    private int sickLeave;

    private int specialLeave;

    private String leaveType;

    public LeaveCount() {
    }

//    public LeaveCount(int id, int empId, String year, int casualLeave, int sickLeave, int specialLeave) {
//        this.id = id;
//        this.empId = empId;
//        this.year = year;
//        this.casualLeave = casualLeave;
//        this.sickLeave = sickLeave;
//        this.specialLeave = specialLeave;

//    }

    public LeaveCount(int id, int empId, String year, int casualLeave, int sickLeave, int specialLeave, String leaveType) {
        this.id = id;
        this.empId = empId;
        this.year = year;
        this.casualLeave = casualLeave;
        this.sickLeave = sickLeave;
        this.specialLeave = specialLeave;
        this.leaveType = leaveType;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(int casualLeave) {
        this.casualLeave = casualLeave;
    }

    public int getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    public int getSpecialLeave() {
        return specialLeave;
    }

    public void setSpecialLeave(int specialLeave) {
        this.specialLeave = specialLeave;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }
}
