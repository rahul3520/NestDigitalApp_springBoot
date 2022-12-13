package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.EmployeeLogsDao;
import com.example.Nest_Digital_App_backend.model.EmployeeLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class EmployeeLogsController {

    @Autowired
    private EmployeeLogsDao eldao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmployeeEntry",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddEmployeeEntry(@RequestBody EmployeeLogs el)
    {
        String eid=String.valueOf(el.getEmpId());
        el.setDate(String.valueOf(java.time.LocalDate.now()));
        el.setEntryDateTime(String.valueOf(java.time.LocalTime.now()));

        eldao.save(el);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","employee entry logged");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addEmployeeExit",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddEmployeeExit(@RequestBody EmployeeLogs el)
    {
        String eid=String.valueOf(el.getEmpId());
        String date=String.valueOf(el.getDate());


//        String exitTime=el.setDate(String.valueOf(java.time.LocalDate.now()));
//        el.setEntryDateTime(String.valueOf(java.time.LocalTime.now()));

        eldao.UpdateExitTime(el.getEmpId(),el.getDate(),String.valueOf(java.time.LocalTime.now()));

        HashMap<String,String> map=new HashMap<>();

        map.put("status","employee exit logged");

        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findallEmployeeLogs")
    public List<EmployeeLogs> FindAllEmployeeLogs()
    {
        return (List<EmployeeLogs>) eldao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/findEmployeeLogsByDate",produces = "application/json",consumes = "application/json")
    public List<EmployeeLogs> FindEmployeeLogsByDate(@RequestBody EmployeeLogs el)
    {
        String date=String.valueOf(el.getDate());

        return (List<EmployeeLogs>) eldao.FindEmpLogsByDate(el.getDate());
    }
}
