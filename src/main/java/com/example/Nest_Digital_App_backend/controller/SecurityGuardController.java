package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.SecurityGuardDao;
import com.example.Nest_Digital_App_backend.model.Employee;
import com.example.Nest_Digital_App_backend.model.SecurityGuard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class SecurityGuardController {

    @Autowired
    private SecurityGuardDao sgdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addSecurityGuard",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddSecurityGuard(@RequestBody SecurityGuard sg)
    {
        String empCode=String.valueOf(sg.getEmpCode());
        String empName=String.valueOf(sg.getName().toString());
        String salary=String.valueOf(sg.getSalary());
        String phoneNo=String.valueOf(sg.getPhoneNo().toString());
        String emailId=String.valueOf(sg.getEmailId().toString());
        String password=String.valueOf(sg.getPassword().toString());

        sgdao.save(sg);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","success");
        map.put("sgID",String.valueOf(sg.getId()));

        return map;

    }
}
