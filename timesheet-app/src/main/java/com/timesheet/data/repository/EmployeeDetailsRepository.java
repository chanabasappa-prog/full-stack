package com.timesheet.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.timesheet.data.modal.Employee;


@Repository
public interface EmployeeDetailsRepository extends JpaRepository<Employee, Long>{

	
}

