package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.EmployeeDao;
import com.example.Nest_Digital_App_backend.dao.LeaveCountDao;
import com.example.Nest_Digital_App_backend.model.LeaveCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        String casualLeave=String.valueOf(l.getCasualLeave());
        String sickLeave=String.valueOf(l.getSickLeave());
        String specialLeave=String.valueOf(l.getSpecialLeave());

        HashMap<String,String> map=new HashMap<>();

        if(Objects.equals(l.getLeaveType(), "Casual"))
        {
            if(l.getCasualLeave()>0)
            {
                ldao.ReduceCasualLeave(l.getEmpId(),l.getCasualLeave());
                map.put("status","casual leave approved");
                map.put("remaining casual leaves",String.valueOf(l.getCasualLeave()));

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
                map.put("remaining sick leaves",String.valueOf(l.getSickLeave()));
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
                map.put("remaining special leaves",String.valueOf(l.getSpecialLeave()));
            }
            else
            {
                map.put("status","No more special leaves remaining");

            }
        }

        return map;

    }

}
