package com.example.Nest_Digital_App_backend.controller;

import com.example.Nest_Digital_App_backend.dao.EmployeeDao;
import com.example.Nest_Digital_App_backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao edao;


    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeRegistration",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> AddEmployee(@RequestBody Employee e)
    {
        String empCode=String.valueOf(e.getEmpCode());
        String empName=String.valueOf(e.getName().toString());
        String designation=String.valueOf(e.getDesignation().toString());
        String salary=String.valueOf(e.getSalary());
        String phoneNo=String.valueOf(e.getPhoneNo().toString());
        String emailId=String.valueOf(e.getEmailId().toString());
        String password=String.valueOf(e.getPassword().toString());

        edao.save(e);

        HashMap<String,String> map=new HashMap<>();

        map.put("status","success");
        map.put("empID",String.valueOf(e.getId()));

        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeLogin",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> EmployeeLogin(@RequestBody Employee e)
    {
        String emailid=String.valueOf(e.getEmailId().toString());
        String password=String.valueOf(e.getPassword().toString());

        List<Employee> result= edao.LoginVerify(e.getEmailId(),e.getPassword());

        HashMap<String,String> map=new HashMap<>();

        if(result.size()==0)
        {
            map.put("status","Invalid");
        }
        else
        {
            map.put("status","success");
            map.put("id",String.valueOf(result.get(0).getId()));
        }

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/employeeProfile",produces = "application/json",consumes = "application/json")
    public List<Employee> EmployeeProfile(@RequestBody Employee e)
    {
        String eid=String.valueOf(e.getId());
        System.out.println(eid);

        return (List<Employee>) edao.GetEmployeeProfile(e.getId());
    }



//    @CrossOrigin(origins = "*")
//    @GetMapping("/findLastEmployeeAdded")
//    public List<Employee> FindLastAddedEmployee()
//    {
//        e.getId()
//        return List<Employee> GetEmployeeLastAdded();
//    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewEmployees")
    public List<Employee> ViewEmployee()
    {
        return (List<Employee>) edao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchEmployee",produces = "application/json",consumes = "application/json")
    public List<Employee> SearchEmployee(@RequestBody Employee e)
    {
        String ecode=String.valueOf(e.getEmpCode());

        return (List<Employee>) edao.FindEmployee(e.getEmpCode());
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deleteEmployee",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> DeleteEmployee(@RequestBody Employee e)
    {
        String eid=String.valueOf(e.getId());

        edao.DeleteEmployee(e.getId());

        HashMap<String,String> map=new HashMap<>();

        map.put("status","employee deleted");

        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updateEmployee",produces = "application/json",consumes = "application/json")
    public HashMap<String,String> UpdateEmployee(@RequestBody Employee e)
    {
        String eid=String.valueOf(e.getId());
        String empCode=String.valueOf(e.getEmpCode());
        String name=String.valueOf(e.getName().toString());
        String designation=String.valueOf(e.getDesignation().toString());
        String salary=String.valueOf(e.getSalary());
        String phoneNo=String.valueOf(e.getPhoneNo().toString());
        String emailId=String.valueOf(e.getEmailId().toString());
        String password=String.valueOf(e.getPassword().toString());

        edao.UpdateEmployeeFields(e.getId(),e.getEmpCode(),e.getName(),e.getDesignation(),e.getSalary(),e.getPhoneNo(),e.getEmailId(),e.getPassword());

        HashMap<String,String> map=new HashMap<>();

        map.put("status","updated employee record!");

        return map;
    }
}
