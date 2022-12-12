package com.example.Nest_Digital_App_backend.dao;

import com.example.Nest_Digital_App_backend.model.LeaveCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LeaveCountDao extends CrudRepository<LeaveCount,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_count` SET `casual_leave`=:casualLeave-1 WHERE `emp_id`=:empId",nativeQuery = true)
    void ReduceCasualLeave(@Param("empId") int empId,@Param("casualLeave") int casualLeave);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_count` SET `sick_leave`=:sickLeave-1 WHERE `emp_id`=:empId",nativeQuery = true)
    void ReduceSickLeave(@Param("empId") int empId,@Param("sickLeave") int sickLeave);

    @Query(value = "UPDATE `leave_count` SET `special_leave`=:specialLeave-1 WHERE `emp_id`=:empId",nativeQuery = true)
    void ReduceSpecialLeave(@Param("empId") int empId,@Param("specialLeave") int specialLeave);
}
