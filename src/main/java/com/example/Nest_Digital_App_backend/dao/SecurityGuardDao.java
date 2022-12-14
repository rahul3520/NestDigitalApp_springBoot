package com.example.Nest_Digital_App_backend.dao;

import com.example.Nest_Digital_App_backend.model.SecurityGuard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityGuardDao extends CrudRepository<SecurityGuard,Integer> {

    @Query(value = "SELECT `id`, `email_id`, `emp_code`, `name`, `password`, `phone_no`, `salary` FROM `security` WHERE `email_id`=:emailId AND `password`=:password",nativeQuery = true)
    List<SecurityGuard> LoginVerify(@Param("emailId") String emailId,@Param("password") String password);

    @Query(value = "SELECT `id`, `email_id`, `emp_code`, `name`, `password`, `phone_no`, `salary` FROM `security` WHERE `id`=:id",nativeQuery = true)
    List<SecurityGuard> GetSecurityGuardProfile(@Param("id") int id);
}
