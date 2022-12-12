package com.example.Nest_Digital_App_backend.dao;

import com.example.Nest_Digital_App_backend.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee,Integer> {


}
