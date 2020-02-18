package com.timesheet.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.timesheet.data.modal.Timesheet;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long>{

	
}
