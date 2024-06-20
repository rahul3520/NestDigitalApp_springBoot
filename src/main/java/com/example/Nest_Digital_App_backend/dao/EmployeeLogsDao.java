package com.example.Nest_Digital_App_backend.dao;

import com.example.Nest_Digital_App_backend.model.EmployeeLogs;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeLogsDao extends CrudRepository<EmployeeLogs,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `employee_logs` SET `exit_date_time`=:exit_date_time WHERE `emp_id`=:empId AND `date`=:date",nativeQuery = true)
    void UpdateExitTime(@Param("empId") int empId,@Param("date") String date,@Param("exit_date_time") String exit_date_time);

    @Query(value = "SELECT `id`, `date`, `emp_id`, `entry_date_time`, `exit_date_time` FROM `employee_logs` WHERE `date`=:date",nativeQuery = true)
    List<EmployeeLogs> FindEmpLogsByDate(@Param("date") String date);

}
