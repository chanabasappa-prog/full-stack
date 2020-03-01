package com.timesheet.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import com.timesheet.AbstractTimesheetAppTest;
import com.timesheet.data.modal.Employee;
import com.timesheet.data.modal.Timesheet;
import com.timesheet.data.repository.EmployeeDetailsRepository;
import com.timesheet.data.repository.TimesheetRepository;

public class TimesheetServiceTest extends AbstractTimesheetAppTest {

	@Mock
    private EmployeeDetailsRepository employeeDetailsRepository;

    @Mock
    private TimesheetRepository timesheetRepository;

    @InjectMocks
    private TimesheetService timesheetService;

    
    private Optional<Timesheet> timesheetsList;


    @Test
    public void whenValidId_thenTimesheetShouldBeFound() {
        Employee employeeDetails = new Employee();
        employeeDetails.setFirstName("Chana");
        employeeDetails.setLastName("Awati");
        employeeDetails.setJoiningDate(new Date());
        employeeDetails.setTerminationDate(null);
        
        Timesheet timesheet = new Timesheet();
        timesheet.setEmployeeDetails(employeeDetails);
        timesheet.setHours(8l);
        timesheet.setTimesheetDate(new Date());
        
        timesheetsList = Optional.of(timesheet);

        Mockito.doReturn(timesheetsList).when(timesheetRepository).findById(Mockito.any());

        Employee found = timesheetService.findById(1l).getEmployeeDetails();

        assertThat("Chana").isEqualTo(found.getFirstName());
    }
    
   @Test
   public void whenValidId_thenasdBeFound() {
       String name="Test";
       assertThat("Test").isEqualTo(name);
   }

}
