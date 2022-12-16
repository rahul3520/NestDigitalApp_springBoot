package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.LeaveApplicationDao;
import com.example.Nest_Digital_App_backend.model.LeaveApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class LeaveApplicationController {

    @Autowired
    private LeaveApplicationDao ladao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addLeave",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddLeave(@RequestBody LeaveApplication la)
    {
        String empId = String.valueOf(la.getEmpId());
        String leaveType = la.getLeaveType();
        String remarks = la.getRemarks();
        String fromDate = String.valueOf(la.getFromDate());
        String toDate = String.valueOf(la.getToDate());
        String applyDate = String.valueOf(la.getApplyDate());
        String leaveStatus = String.valueOf(la.getLeaveStatus());


        ladao.save(la);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","applied for leave");

        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/handleLeave",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> HandleLeave(@RequestBody LeaveApplication la)
    {
        String id=String.valueOf(la.getId());
        String empId=String.valueOf(la.getEmpId());
//        String leaveType=String.valueOf(la.getLeaveType());

        String leaveStatus=String.valueOf(la.getLeaveStatus());

        ladao.UpdateLeaveStatus(la.getId(),la.getEmpId(),la.getLeaveStatus());

        HashMap<String,String> map=new HashMap<>();

        if(Objects.equals(leaveStatus, "1")) //leave approved
        {
            map.put("status","leave approved");
            map.put("empId",String.valueOf(la.getEmpId()));
            map.put("leaveType",la.getLeaveType());
        }
        else if(Objects.equals(la.getLeaveStatus(), "0"))
        {
            map.put("status","Leave in processing");
        }
        else
        {
            map.put("status","leave not approved");
        }

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewAppliedLeaveStatus",produces = "application/json",consumes = "application/json")
    public List<LeaveApplication> ViewLeaveAppliedStatus(@RequestBody LeaveApplication la)
    {
        int empid=la.getEmpId();

        return ladao.FindLeaveStatus(la.getEmpId());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewLeaveApplicationWithLeaveCount")
    public List<Map<String,String>> ViewAllLeavesApplied()
    {
        return ladao.FindAllLeaveApplied();
    }

}
