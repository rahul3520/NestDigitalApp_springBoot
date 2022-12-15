package com.example.Nest_Digital_App_backend.dao;

import com.example.Nest_Digital_App_backend.model.LeaveApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface LeaveApplicationDao extends CrudRepository<LeaveApplication,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_application` SET `leave_status`=:leaveStatus WHERE `id`=:id AND `emp_id`=:empId",nativeQuery = true)
    void UpdateLeaveStatus(@Param("id") int id,@Param("empId") int empId,@Param("leaveStatus") String leaveStatus);

    @Query(value = "SELECT la.`id`, la.`apply_date`, la.`emp_id`, la.`from_date`, la.`leave_status`, la.`leave_type`, la.`remarks`, lc.emp_id,la.`to_date`,lc.year,lc.casual_leave,lc.sick_leave,lc.special_leave \n" +
            "FROM `leave_application` AS la \n" +
            "JOIN leave_count AS lc \n" +
            "ON la.emp_id=lc.emp_id ",nativeQuery = true)
    List<Map<String,String>> FindAllLeaveApplied();

}
