package com.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesheet.data.modal.Timesheet;
import com.timesheet.data.repository.TimesheetRepository;

@Service
public class TimesheetService {
	
	@Autowired
	private TimesheetRepository timesheetRepository;
	
	public List<Timesheet> list(){
		return timesheetRepository.findAll();
	}
	
	public Timesheet findById(Long id) {
		return timesheetRepository.findById(id).get();
	}
	
	public Timesheet save(Timesheet timesheet) {
		return timesheetRepository.save(timesheet);
	}
	
	public void delete(Timesheet timesheet) {
		timesheetRepository.delete(timesheet);
	}
	
	
}
