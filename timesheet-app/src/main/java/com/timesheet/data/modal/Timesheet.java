package com.timesheet.data.modal;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TIMESHEET")
public class Timesheet {

	public Timesheet() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long employeeId;
	private String timesheetDate;
	private Long  hours;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getTimesheetDate() {
		return timesheetDate;
	}
	public void setTimesheetDate(String timesheetDate) {
		this.timesheetDate = timesheetDate;
	}
	public Long getHours() {
		return hours;
	}
	public void setHours(Long hours) {
		this.hours = hours;
	}
	@Override
	public String toString() {
		return "Timesheet [id=" + id + ", employeeId=" + employeeId + ", timesheetDate=" + timesheetDate + ", hours="
				+ hours + "]";
	}
	
	
	

	
}
