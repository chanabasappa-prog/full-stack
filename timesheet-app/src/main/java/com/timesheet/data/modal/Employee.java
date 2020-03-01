package com.timesheet.data.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Employee")
public class Employee {

	public Employee() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="termination_date")
	private Date terminationDate;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", joiningDate=" + joiningDate + ", terminationDate=" + terminationDate
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

	
}
