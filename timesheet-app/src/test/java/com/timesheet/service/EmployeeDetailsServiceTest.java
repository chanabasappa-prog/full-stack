package com.timesheet.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timesheet.AbstractTimesheetAppTest;
import com.timesheet.data.modal.Employee;
import com.timesheet.data.modal.Timesheet;
import com.timesheet.data.repository.EmployeeDetailsRepository;
import com.timesheet.data.repository.TimesheetRepository;

public class EmployeeDetailsServiceTest extends AbstractTimesheetAppTest {

    @Mock
    private EmployeeDetailsRepository employeeDetailsRepository;

    @InjectMocks
    private EmployeeDetailsService employeeDetailsService;

    private Optional<Employee> employeeDetailsList;


    @Test
    public void whenValidId_thenEmployeeShouldBeFound() {
        Employee employeeDetails = new Employee();
        employeeDetails.setFirstName("Chana");
        employeeDetails.setLastName("Awati");
        employeeDetails.setJoiningDate(new Date());
        employeeDetails.setTerminationDate(new Date());
        
        employeeDetailsList = Optional.of(employeeDetails);
        
        Mockito.doReturn(employeeDetailsList).when(employeeDetailsRepository).findById(Mockito.any());

        Employee found = employeeDetailsService.findById(1l);

        assertThat("Chana").isEqualTo(found.getFirstName());
    }
    
   @Test
   public void whenValidId_thenasdBeFound() {
       String name="Test";
       assertThat("Test").isEqualTo(name);
   }
}
