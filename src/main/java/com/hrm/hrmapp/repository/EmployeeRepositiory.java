package com.hrm.hrmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrm.hrmapp.entity.Employee;

@Repository
public interface EmployeeRepositiory extends JpaRepository<Employee, Long>{

}
