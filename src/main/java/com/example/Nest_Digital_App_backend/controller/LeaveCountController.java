package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.EmployeeDao;
import com.example.Nest_Digital_App_backend.dao.LeaveCountDao;
import com.example.Nest_Digital_App_backend.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.time.LocalDate;



@RestController
public class LeaveCountController {

    @Autowired
    private LeaveCountDao ldao;

//    Date d=new Date();
//    int year=d.getYear();
    LocalDate current_date = LocalDate.now();

    int current_Year = current_date.getYear();

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/initializeNewEmployee",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> InitializeNewEmployee(@RequestBody LeaveCount l)
    {
        String eid=String.valueOf(l.getEmpId());
        l.setYear(String.valueOf(current_Year));
        l.setCasualLeave(20);
        l.setSickLeave(7);
        l.setSpecialLeave(3);

        ldao.save(l);

        System.out.println(eid);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","employee added to leave count");

        return map;
    }

}
