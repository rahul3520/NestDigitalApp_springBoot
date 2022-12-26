package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.EmployeeDao;
import com.example.Nest_Digital_App_backend.dao.LeaveCountDao;
import com.example.Nest_Digital_App_backend.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
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

//    public List<LeaveCount> GetCurrentLeaveCount(@RequestBody LeaveCount l)
//    {
//        String eid=String.valueOf(l.getEmpId());
//        String leaveid=String.valueOf(l.getId());
//
//        return (List<LeaveCount>) ldao.GetCurrentLeaveCount(l.getEmpId(),l.getId());
//    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/reduceLeaveCount",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> ReduceLeaveCount(@RequestBody LeaveCount l)
    {
        String empid=String.valueOf(l.getEmpId());
        String leavetype=String.valueOf(l.getLeaveType());
        int casualLeave=l.getCasualLeave();
        int sickLeave=l.getSickLeave();
        int specialLeave=l.getSpecialLeave();

        HashMap<String,String> map=new HashMap<>();

        if(Objects.equals(l.getLeaveType(), "Casual"))
        {
            if(l.getCasualLeave()>0)
            {
                ldao.ReduceCasualLeave(l.getEmpId(),l.getCasualLeave());
                map.put("status","casual leave approved");
                map.put("remainingCasualLeaves",String.valueOf(l.getCasualLeave()-1));

            }
            else
            {
                map.put("status","No more casual leaves remaining");

            }
        } else if (Objects.equals(l.getLeaveType(), "Sick"))
        {
            if(l.getSickLeave()>0)
            {
                ldao.ReduceSickLeave(l.getEmpId(),l.getSickLeave());
                map.put("status","sick leave approved");
                map.put("remainingSickLeaves",String.valueOf(l.getSickLeave()-1));
            }
            else
            {
                map.put("status","No more sick leaves remaining");

            }
        }

        else
        {
            if(l.getSpecialLeave()>0)
            {
                ldao.ReduceSpecialLeave(l.getEmpId(),l.getSpecialLeave());
                map.put("status","special leave approved");
                map.put("remainingSpecialLeaves",String.valueOf(l.getSpecialLeave()-1));
            }
            else
            {
                map.put("status","No more special leaves remaining");

            }
        }

        return map;

    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewAllLeaveCountOfAllEmployees")
    public List<LeaveCount> ViewAllLeaveCountData()
    {
        return (List<LeaveCount>) ldao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewRemainingLeaves",produces = "application/json",consumes = "application/json")
    public List<LeaveCount> ViewRemainingLeaves(@RequestBody LeaveCount lc)
    {
        int empid=lc.getEmpId();

        System.out.println(empid);

        return ldao.FindLeavesRemaining(lc.getEmpId());
    }

}
