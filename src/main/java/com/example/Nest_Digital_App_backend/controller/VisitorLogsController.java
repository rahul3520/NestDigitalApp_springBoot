package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.VisitorLogsDao;
import com.example.Nest_Digital_App_backend.dao.VisitorLogsDao;
import com.example.Nest_Digital_App_backend.model.VisitorLogs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class VisitorLogsController {

    @Autowired
    private VisitorLogsDao vldao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addVisitorEntry",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddVisitorEntry(@RequestBody VisitorLogs vl)
    {
//        String eid=String.valueOf(vl.getId());
        String name=String.valueOf(vl.getName());
        String purpose=String.valueOf(vl.getPurpose());
        String whomtomeet=String.valueOf(vl.getWhomToMeet());
        vl.setDate(String.valueOf(java.time.LocalDate.now()));
        vl.setEntryDateTime(String.valueOf(java.time.LocalTime.now()));

        vldao.save(vl);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","visitor entry logged");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addVisitorExit",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddEmployeeExit(@RequestBody VisitorLogs vl)
    {
        String eid=String.valueOf(vl.getId());
        String date=String.valueOf(vl.getDate());


//        String exitTime=el.setDate(String.valueOf(java.time.LocalDate.now()));
//        el.setEntryDateTime(String.valueOf(java.time.LocalTime.now()));

        vldao.UpdateExitTime(vl.getId(),vl.getDate(),String.valueOf(java.time.LocalTime.now()));

        HashMap<String,String> map=new HashMap<>();

        map.put("status","visitor exit logged");

        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/findallVisitorLogs")
    public List<VisitorLogs> FindAllEmployeeLogs()
    {
        return (List<VisitorLogs>) vldao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/findVisitorLogsByDate",produces = "application/json",consumes = "application/json")
    public List<VisitorLogs> FindEmployeeLogsByDate(@RequestBody VisitorLogs vl)
    {
        String date=String.valueOf(vl.getDate());

        return (List<VisitorLogs>) vldao.FindVisitorLogsByDate(vl.getDate());
    }
}
