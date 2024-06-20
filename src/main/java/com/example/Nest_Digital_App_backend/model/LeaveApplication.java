package com.example.Nest_Digital_App_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "leaveApplication")
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int empId;

    private String leaveType;

    private String remarks;

    private String fromDate;

    private String toDate;

    private String applyDate;

    private String leaveStatus;

    public LeaveApplication() {
    }

    public LeaveApplication(int id, int empId, String leaveType, String remarks, String fromDate, String toDate, String applyDate, String leaveStatus) {
        this.id = id;
        this.empId = empId;
        this.leaveType = leaveType;
        this.remarks = remarks;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.applyDate = applyDate;
        this.leaveStatus = leaveStatus;
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

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }
}
