package com.example.Nest_Digital_App_backend.dao;

import com.example.Nest_Digital_App_backend.model.LeaveApplication;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LeaveApplicationDao extends CrudRepository<LeaveApplication,Integer> {

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leave_application` SET `leave_status`=:leaveStatus WHERE `id`=:id AND `emp_id`=:empId",nativeQuery = true)
    void UpdateLeaveStatus(@Param("id") int id,@Param("empId") int empId,@Param("leaveStatus") String leaveStatus);

}
