package com.example.Nest_Digital_App_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int empCode;

    private String name;


}
