package com.example.Nest_Digital_App_backend.dao;

import com.example.Nest_Digital_App_backend.model.LeaveCount;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LeaveCountDao extends CrudRepository<LeaveCount,Integer> {

//    @Query(value = "SELECT `casual_leave`, `sick_leave`, `special_leave`, `leave_type` FROM `leave_count` WHERE `emp_id`=:empId",nativeQuery = true)
//    List<LeaveCount> GetCurrentLeaveCount(@Param("empId") int empId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_count` SET `casual_leave`= :casual_leave-1 WHERE `emp_id`=:empId",nativeQuery = true)
    void ReduceCasualLeave(@Param("empId") int empId,@Param("casual_leave") int casual_leave);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_count` SET `sick_leave`= :sick_leave-1 WHERE `emp_id`=:empId",nativeQuery = true)
    void ReduceSickLeave(@Param("empId") int empId,@Param("sick_leave") int sick_leave);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_count` SET `special_leave`= :special_leave-1 WHERE `emp_id`=:empId",nativeQuery = true)
    void ReduceSpecialLeave(@Param("empId") int empId,@Param("special_leave") int special_leave);

    @Query(value = "SELECT `id`, `casual_leave`, `emp_id`, `sick_leave`, `special_leave`, `year`, `leave_type` FROM `leave_count` WHERE `emp_id`=:empId",nativeQuery = true)
    List<LeaveCount> FindLeavesRemaining(@Param("empId") int empId);
}
