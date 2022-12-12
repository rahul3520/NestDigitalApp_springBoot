package com.example.Nest_Digital_App_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "security")
public class SecurityGuard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int empCode;

    private String name;

    private int salary;

    private String phoneNo;

    private String emailId;

    private String password;

    public SecurityGuard() {
    }

    public SecurityGuard(int id, int empCode, String name, int salary, String phoneNo, String emailId, String password) {
        this.id = id;
        this.empCode = empCode;
        this.name = name;
        this.salary = salary;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpCode() {
        return empCode;
    }

    public void setEmpCode(int empCode) {
        this.empCode = empCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
