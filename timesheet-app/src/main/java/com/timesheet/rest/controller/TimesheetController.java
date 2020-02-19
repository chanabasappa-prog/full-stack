package com.timesheet.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.timesheet.data.modal.Timesheet;
import com.timesheet.service.TimesheetService;

@RestController()

public class TimesheetController {
	
	@Autowired
    private TimesheetService timesheetsService;

	@GetMapping("/timesheets")
	public List<Timesheet> getAllTimesheets() {
		List<Timesheet> timesheets = timesheetsService.list();
		System.out.println("getAllTimesheets() method called");
		return timesheets;
		
	}

	@GetMapping("/timesheets/{timesheetId}")
	public Timesheet getTimesheetById(@PathVariable String timesheetId) {
		System.out.println("getTimesheetById() method called");
		return timesheetsService.findById(Long.parseLong(timesheetId));
	}
	
	@PostMapping("/save/timesheet")
    public Timesheet createPost() {
		Timesheet timesheet = new Timesheet();
		timesheet.setEmployeeId(2l);
		timesheet.setHours(8l);
		timesheet.setTimesheetDate("18/02/2020");
		System.out.println(timesheet.getId() + " :: " + timesheet.getEmployeeId());
        return timesheetsService.save(timesheet);
    }
	
	
	/*@PostMapping("/timesheets")
    public Timesheet createPost(@Valid @RequestBody Timesheet timesheet) {
		System.out.println(timesheet.getId() + " :: " + timesheet.getEmployeeId());
        return timesheetsService.save(timesheet);
    }
	
	@DeleteMapping("timesheets/{timesheetId}")
    public ResponseEntity<?> deletePost(@PathVariable Long timesheetId) {
		Timesheet timesheet = timesheetsService.findById(timesheetId);
		timesheetsService.delete(timesheet);
        return ResponseEntity.ok().build();
    }*/
}
